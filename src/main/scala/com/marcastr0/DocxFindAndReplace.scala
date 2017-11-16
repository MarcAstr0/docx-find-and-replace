package com.marcastr0

import java.io.{FileInputStream, InputStream}

import org.apache.poi.xwpf.usermodel.XWPFDocument

object DocxFindAndReplace {
  def main(args: Array[String]): Unit = {
    if (args.length == 0) {
      println("Must receive a Word file as input.")
    } else {
      val docxFile = args(0)
      val string = args(1)
      val fileStream: InputStream = new FileInputStream(docxFile)
      val document = new XWPFDocument(fileStream)

      println(DocxReader.findString(document, string))
    }
  }
}
