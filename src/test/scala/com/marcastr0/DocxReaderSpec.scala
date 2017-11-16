package com.marcastr0

import java.io.InputStream

import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.scalatest.FlatSpec

class DocxReaderSpec extends FlatSpec {
  "findString" should "find whether a text contains a string (without using regex)" in {
    val docxFile: InputStream = getClass.getResourceAsStream("/helloworld.docx")
    val document = new XWPFDocument(docxFile)

    assert(DocxReader.findString(document, "Hello World"))
    assert(!DocxReader.findString(document, "Hello Wrld"))
    assert(DocxReader.findString(document, "Lorem ipsum"))
    assert(!DocxReader.findString(document, "lorem ipsum"))
  }
}
