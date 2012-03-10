package com.example

import unfiltered.netty.cycle.Planify

import unfiltered.response.Html

import java.net.URL

object Templates {
  import scala.xml._
  def layout(body: NodeSeq) =
    Html(
      <html>
        <head>
          <link type="text/css" href="/css/app.css"/>
          <script type="text/javascript" src="/js/app.js"></script>
        </head>
        <body>yep. it works</body>
     </html>)

  def index = layout(<div>it works</div>)

}

/** embedded server */
object Server {
  val logger = org.clapper.avsl.Logger(Server.getClass)
  def main(args: Array[String]) {
    unfiltered.netty.Http(8080)
<<<<<<< HEAD
      .handler(SearchPlan)
      .run { s =>
=======
      .resources(getClass.getResource("/www"))
      .handler(Planify{
        case _ => Templates.index
      }).run { s =>
>>>>>>> 28ac54060fef5cc55b1d25e7e45e53768a5d43dd
        logger.info("starting unfiltered app at localhost on port %s"
                    .format(s.port))
        unfiltered.util.Browser.open(
          "http://127.0.0.1:%d/".format(s.port)
        )
      }
  }
}
