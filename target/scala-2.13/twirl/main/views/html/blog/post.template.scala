
package views.html.blog


object post extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[String,String,String,String,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(layout: String = "post", title: String, author: String, categories: String, tags: String, image: String, content: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""---
layout: """),_display_(/*3.10*/(layout)),format.raw/*3.18*/("""
"""),format.raw/*4.1*/("""title:  """),_display_(/*4.10*/(title)),format.raw/*4.17*/("""
"""),format.raw/*5.1*/("""author: """),_display_(/*5.10*/(author)),format.raw/*5.18*/("""
"""),format.raw/*6.1*/("""categories: [ """),_display_(/*6.16*/(categories)),format.raw/*6.28*/(""" """),format.raw/*6.29*/("""]
tags: ["""),_display_(/*7.9*/(tags)),format.raw/*7.15*/("""]
image: """),_display_(/*8.9*/(image)),format.raw/*8.16*/("""
"""),format.raw/*9.1*/("""---

"""),_display_(/*11.2*/(content)))
      }
    }
  }

  def render(layout:String,title:String,author:String,categories:String,tags:String,image:String,content:String): play.twirl.api.HtmlFormat.Appendable = apply(layout,title,author,categories,tags,image,content)

  def f:((String,String,String,String,String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (layout,title,author,categories,tags,image,content) => apply(layout,title,author,categories,tags,image,content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/blog/post.scala.html
                  HASH: d663bc485b5c2cfb1cfc8373474fc769bad67781
                  MATRIX: 371->1|587->124|626->137|654->145|681->146|716->155|743->162|770->163|805->172|833->180|860->181|901->196|933->208|961->209|996->219|1022->225|1057->235|1084->242|1111->243|1143->249
                  LINES: 8->1|13->2|14->3|14->3|15->4|15->4|15->4|16->5|16->5|16->5|17->6|17->6|17->6|17->6|18->7|18->7|19->8|19->8|20->9|22->11
                  -- GENERATED --
              */
          