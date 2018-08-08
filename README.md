# gitbucket-application-logs-plugin

[![](https://travis-ci.org/YoshinoriN/gitbucket-application-logs-plugin.svg?branch=master)](https://travis-ci.org/YoshinoriN/gitbucket-application-logs-plugin) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/64706d3697aa4548b043bae8ea90cfb6)](https://www.codacy.com/app/YoshinoriN/gitbucket-application-logs-plugin?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=YoshinoriN/gitbucket-application-logs-plugin&amp;utm_campaign=Badge_Grade)

# Features

[GitBucket](//github.com/gitbucket/gitbucket) log feature support plugin for Administrator.

* Display LogBack configuration
* Reload LogBack configuration
* Download GitBucket log
* GitBucket logs viewer
    * Multiple logs support
    * Selectable Sort type (ascending or descending from tail of the log)
    * Specify the number of display less than 10000

# Images

![](https://raw.githubusercontent.com/YoshinoriN/gitbucket-application-logs-plugin/master/doc/images/config.png)
![](https://raw.githubusercontent.com/YoshinoriN/gitbucket-application-logs-plugin/master/doc/images/logs.png)
![](https://raw.githubusercontent.com/YoshinoriN/gitbucket-application-logs-plugin/master/doc/images/viewer.png)

# Download & Installation

1. Download plugin jar file from [the release page](//github.com/YoshinoriN/gitbucket-application-logs-plugin/releases).
2. Put plugin jar file into `GITBUCKET_HOME/plugins` and restart GitBucket.

# UI Usage

Goto the `System Administration` menu, you can see `Application Logs` section.

# Compatibility with GitBucket

|Plugin version|GitBucket version|
|:-------------:|:-------:|
|1.0.0|4.25.0 - 4.27.0|
|0.2.0|4.25.0 - 4.27.0|
|0.1.0|4.25.0 - 4.27.0|

# Build from source

```sh
sbt package
```

The built package will be created at `/target/scala-2.12/gitbucket-application-logs-plugin_2.12-{plugin-version}.jar`

# License

This project is under the Apache License, Version 2.0 License. See the [LICENSE](./LICENSE) file for the full license text.
