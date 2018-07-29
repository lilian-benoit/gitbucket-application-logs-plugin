package net.yoshinorin.gitbucket.applicationlogs.controllers

import scala.util.{Failure, Success, Try}
import org.slf4j.LoggerFactory
import gitbucket.core.controller.ControllerBase
import gitbucket.core.util.AdminAuthenticator
import net.yoshinorin.gitbucket.applicationlogs.models.{LogBack, LogFile}
import net.yoshinorin.gitbucket.applicationlogs.services.ApplicationLogService
import net.yoshinorin.gitbucket.applicationlogs.utils.Error

class ApplicationLogsController extends ControllerBase with AdminAuthenticator with ApplicationLogService {

  private val logger = LoggerFactory.getLogger(getClass)

  get("/admin/application-logs")(adminOnly {
    redirect(s"/admin/application-logs/configuration")
  })

  get("/admin/application-logs/configuration")(adminOnly {
    net.yoshinorin.gitbucket.applicationlogs.html.configuration(
      LogBack.isEnable,
      LogBack.getConfigurationFilePath,
      LogBack.readConfigurationFile
    )
  })

  get("/admin/application-logs/list")(adminOnly {

    LogBack.isEnable match {
      case true => {
        net.yoshinorin.gitbucket.applicationlogs.html.list(
          LogBack.isEnable,
          LogBack.logFiles
        )
      }
      case false => NotFound()
    }

  })

  get("/admin/application-logs/:id/view")(adminOnly {

    val logId = params("id").toInt

    LogBack.logFiles.get.find(_.id == logId) match {
      case Some(logFile) => {
        var n = defaultDisplayLines
        val lineNum = request.getParameter("lines")
        if (Try(lineNum.toInt).toOption.isDefined) {
          n = lineNum.toInt
        }
        val logs = readLog(logFile, n) match {
          case Success(s) =>
            s match {
              case Some(s) => Right(s)
              case None => Left(Error.FILE_NOT_FOUND)
            }
          case Failure(f) => {
            logger.error(f.toString)
            Left(Error.FAILURE)
          }
        }
        net.yoshinorin.gitbucket.applicationlogs.html.logviewer(
          LogBack.isEnable,
          logFile,
          defaultDisplayLines,
          displayLimitLines,
          logs,
          n
        )
      }
      case None => NotFound()
    }
  })
}
