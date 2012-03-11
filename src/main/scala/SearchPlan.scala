package nescala

import unfiltered.request._
import unfiltered.response._
import unfiltered.netty._

object SearchPlan
  extends async.Plan
  with ServerErrorResponse {

  val logger = org.clapper.avsl.Logger(getClass)
  
  def intent = {
    case req@GET(Path("/search")) => 
      logger.debug("GET /")
      req.respond(Templates.index)

    case req@GET(Path("/rsvps")) =>
      import dispatch._
      (Props.get("mu.apikey"), Props.get("mu.event")) match {
        case (Some(key), Some(event)) =>
          for {
            json <- Http(url("https://api.meetup.com/2/rsvps/") <<? Map(
              "key" -> key,
              "sign" -> "true",
              "event_id" -> event) > As.string)
          } req.respond(JsonContent ~> ResponseString(json))
        case _ => req.respond(InternalServerError ~> ResponseString(
          "someone forgot to configure the server"))
      }

  }
}
