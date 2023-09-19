
package com.scalatsi.generator

import _root_.com.scalatsi._
import _root_.com.scalatsi.TypescriptType._

/** User imports */


object ExportTypescript {
  import _root_.com.{ scalatsi => ts }
  import _root_.scala.collection.{ immutable => im }

  // If you get a generator or implicit not found error here, make sure you have defined a TSType[T] implicit and imported it
  val toOutput: im.Map[String, ts.TypescriptType] = im.Map[String, ts.TypescriptType](
    
  )

  val options = ts.output.OutputOptions(
    targetFile = new _root_.java.io.File("""/app/modules/flyway/target/scala-tsi.ts"""), // Warning: always use literal string here for windows paths with \
    styleOptions = ts.output.StyleOptions(
      semicolons = false,
      taggedUnionDiscriminator =  Some("""type""") 
    ),
    header = if("""// DO NOT EDIT: generated file by scala-tsi""" == "") None else Some("""// DO NOT EDIT: generated file by scala-tsi""")
  )

  def main(args: Array[String]): Unit = {
    ts.output.WriteTSToFiles.generate(options)(toOutput)
  }
}
