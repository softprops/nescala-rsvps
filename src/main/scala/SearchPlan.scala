package com.example

import unfiltered.request._
import unfiltered.response._

import unfiltered.netty._

/** unfiltered plan */
object SearchPlan extends cycle.Plan
  with cycle.SynchronousExecution with ServerErrorResponse {

  val logger = org.clapper.avsl.Logger(getClass)
  
  def intent = {
    case GET(Path("/search")) => 
      logger.debug("GET /")
      ResponseString("Hi")
  }
}
