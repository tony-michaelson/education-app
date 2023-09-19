
package views.html.blog

/*1.2*/import models.blog.JekyllConfig

object jekyll_config extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[JekyllConfig,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(config: JekyllConfig):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.1*/("""
"""),format.raw/*5.1*/("""# Site
name: """"),_display_(/*6.9*/config/*6.15*/.site.name),format.raw/*6.25*/(""""
description: """"),_display_(/*7.16*/config/*7.22*/.site.description),format.raw/*7.39*/(""""
logo: """"),_display_(/*8.9*/config/*8.15*/.site.logo),format.raw/*8.25*/(""""
favicon: """"),_display_(/*9.12*/config/*9.18*/.site.favicon),format.raw/*9.31*/(""""
baseurl: ''
include: ["_pages"]
permalink: /:title/
email: ""

# Plugins
plugins:
    - jekyll-paginate
    - jekyll-sitemap
    - jekyll-feed
    - jekyll-seo-tag
    - jekyll-archives
    - jekyll-figure

# Archives
jekyll-archives:
    enabled:
        - categories
    layout: archive
    permalinks:
        category: '/category/:name/'

# Pagination
paginate: 6
paginate_path: /page:num/

# Other
highlighter: none
markdown: kramdown
kramdown:
    syntax_highlighter_opts:
        disable : true

# Adsense (change to "enabled" to activate, also your client id and ad slot. Create a new ad unit from your Adsense account to get the slot.)
adsense: "disabled"
# adsense-data-ad-client: ""
# adsense-data-ad-slot: ""

# Lazy Images ("enabled" or "disabled")
lazyimages: "disabled"

# Post Author Box ("enabled" or "disabled")
authorbox: "disabled"

# Sass
sass:
    sass_dir: _sass
    style: compressed

exclude: [changelog.md, LICENSE.txt, README.md, Gemfile, Gemfile.lock]"""))
      }
    }
  }

  def render(config:JekyllConfig): play.twirl.api.HtmlFormat.Appendable = apply(config)

  def f:((JekyllConfig) => play.twirl.api.HtmlFormat.Appendable) = (config) => apply(config)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/blog/jekyll_config.scala.html
                  HASH: af34af70e7f71f375e19681353b7e5c64c3f19e1
                  MATRIX: 33->1|383->35|499->58|526->59|566->74|580->80|610->90|653->107|667->113|704->130|739->140|753->146|783->156|822->169|836->175|869->188
                  LINES: 4->1|9->3|14->4|15->5|16->6|16->6|16->6|17->7|17->7|17->7|18->8|18->8|18->8|19->9|19->9|19->9
                  -- GENERATED --
              */
          