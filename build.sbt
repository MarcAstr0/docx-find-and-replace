name := "docx-find-and-replace"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.4",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test",
  "org.apache.poi" % "poi" % "3.15-beta2",
  "org.apache.poi" % "poi-ooxml" % "3.15-beta2",
  "org.apache.poi" % "poi-ooxml-schemas" % "3.15-beta2",
  "org.apache.poi" % "poi-scratchpad" % "3.15-beta2"
)

mainClass := Some("com.marcastr0.DocxFindAndReplace")