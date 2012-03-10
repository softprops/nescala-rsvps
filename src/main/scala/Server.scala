package nescala

import unfiltered.netty.cycle.Planify

import java.net.URL

/** embedded server */
object Server {
  val logger = org.clapper.avsl.Logger(Server.getClass)
  def main(args: Array[String]) {
    unfiltered.netty.Http(8080)
      .handler(SearchPlan)
      .resources(getClass.getResource("/www"))
      .run { s =>
        logger.info("starting unfiltered app at localhost on port %s"
                    .format(s.port))
        unfiltered.util.Browser.open(
          "http://127.0.0.1:%d/search".format(s.port)
        )
      }
  }
}
