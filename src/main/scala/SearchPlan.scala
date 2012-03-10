package nescala

import unfiltered.request._
import unfiltered.response._

import unfiltered.netty._

/** unfiltered plan */
object SearchPlan extends async.Plan
  with ServerErrorResponse {

  val logger = org.clapper.avsl.Logger(getClass)
  
  def intent = {
    case req@GET(Path("/search")) => 
      logger.debug("GET /")
      req.respond(ResponseString("Hi"))

    case req@GET(Path("/rsvps")) =>
      import dispatch._

      for {
        json <- Http(url("https://api.meetup.com/2/rsvps?key=5b3f7f62b575010a586d255c55322e&sign=true&event_id=44042982&page=20") > As.string)
      } req.respond(ResponseString(json))

  }
}
