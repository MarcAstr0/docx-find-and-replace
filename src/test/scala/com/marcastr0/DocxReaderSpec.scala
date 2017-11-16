package com.marcastr0

import java.io.InputStream

import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.scalatest.FlatSpec

class DocxReaderSpec extends FlatSpec {
  val docxFile: InputStream = getClass.getResourceAsStream("/helloworld.docx")
  val document = new XWPFDocument(docxFile)

  "findString" should "find whether a document contains a string (without using regex)" in {
    assert(DocxReader.findString(document, "Hello World"))
    assert(!DocxReader.findString(document, "Hello Wrld"))
    assert(DocxReader.findString(document, "Lorem ipsum"))
    assert(!DocxReader.findString(document, "lorem ipsum"))
  }

  "findRegex" should "find whether a document contains a string that matches the given regular expression" in {
    assert(DocxReader.findRegex(document, "^Hello World!$"))
    assert(DocxReader.findRegex(document, "^Hello \\w+!$"))
    assert(DocxReader.findRegex(document, "Lorem .+, consectetur"))
    // assert(!DocxReader.findRegex(document, "Lorem \\w+[,]{1} dolor"))
    // assert(!DocxReader.findRegex(document, "Lorem .+, adipiscing"))
  }
}
