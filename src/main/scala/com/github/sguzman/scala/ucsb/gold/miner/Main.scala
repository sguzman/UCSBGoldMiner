package com.github.sguzman.scala.ucsb.gold.miner

import com.beust.jcommander.JCommander
import com.github.sguzman.scala.ucsb.gold.miner.args.Args
import com.github.sguzman.scala.ucsb.gold.miner.filter.CourseFilter
import com.github.sguzman.scala.ucsb.gold.miner.login.Cookies
import com.github.sguzman.scala.ucsb.gold.miner.scrape.CourseScrape

object Main {
  def main(args: Array[String]): Unit = {
    val argv = new Args
    val j = JCommander.newBuilder()
      .addObject(argv)
      .build()

    j.parse(args: _*)
    if (argv.help) {
      j.usage()
      System.exit(0)
    }

    val cookies = Cookies(argv)
    val classes = CourseScrape(cookies)
    val filtered = CourseFilter(classes)

    println()
  }
}
