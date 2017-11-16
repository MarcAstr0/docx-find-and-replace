package com.marcastr0

import org.apache.poi.xwpf.extractor.XWPFWordExtractor
import org.apache.poi.xwpf.usermodel.XWPFDocument

import scala.util.matching.Regex

object DocxReader {
  def findString(document: XWPFDocument, string: String): Boolean = {
    val extractor = new XWPFWordExtractor(document)
    val text = extractor.getText
    text contains string
  }

  def findRegex(document: XWPFDocument, regex: String): Boolean = {
    val pattern = new Regex(regex)
    val extractor = new XWPFWordExtractor(document)
    val text = extractor.getText
    val mtch = pattern.findFirstIn(text)
    mtch.getOrElse(false) match {
      case false => false
      case _ => true
    }
  }
}
