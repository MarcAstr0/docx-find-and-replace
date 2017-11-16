package com.marcastr0

import org.apache.poi.xwpf.extractor.XWPFWordExtractor
import org.apache.poi.xwpf.usermodel.XWPFDocument

object DocxReader {
  def findString(document: XWPFDocument, string: String): Boolean = {
    val extractor = new XWPFWordExtractor(document)
    val text = extractor.getText
    text contains string
  }
}
