package com.marcastr0

import java.io.{File, FileInputStream, InputStream}

import org.apache.poi.xwpf.usermodel.XWPFDocument

object DocxFindAndReplace {

  val usage =
    """
      |Usage: [--regex] pattern filename
    """.stripMargin

  def main(args: Array[String]): Unit = {
    if (args.length == 0) {
      println(usage)
      sys.exit(1)
    }

    args.toList.head match {
      case "--regex" =>
        val fileStream: InputStream = new FileInputStream(args(2))
        val document = new XWPFDocument(fileStream)
        println(DocxReader.findRegex(document, args(1)))
      case _ =>
        val fileStream: InputStream = new FileInputStream(args(1))
        val document = new XWPFDocument(fileStream)
        println(DocxReader.findString(document, args(0)))
    }

  }
}
