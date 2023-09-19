
package views.html.email


object orgInvite extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(inviteLink: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<h1>Organizational Invite</h1>

<p>You are invited to join the most amazing learning platform on Earth!</p>

<p><a href=""""),_display_(/*7.14*/(inviteLink)),format.raw/*7.26*/("""">Click Here to Join</a></p>

<p>
    Thank you,</br>
    MasteryPath Team
</p>"""))
      }
    }
  }

  def render(inviteLink:String): play.twirl.api.HtmlFormat.Appendable = apply(inviteLink)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (inviteLink) => apply(inviteLink)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/email/orgInvite.scala.html
                  HASH: f11b4aacf463db24310f55013a05e4d820be1aa6
                  MATRIX: 335->1|449->22|476->23|624->145|656->157
                  LINES: 8->1|13->2|14->3|18->7|18->7
                  -- GENERATED --
              */
          