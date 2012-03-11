package nescala

object Templates {
  import scala.xml._
  import unfiltered.response.Html
  def layout(body: NodeSeq) =
    Html(
      <html>
        <head>
          <title>nescala rsvps</title>
          <link type="text/css" href="/css/app.css"/>          
        </head>
        <body>
          yep. it works
         <script type="text/javascript" src="/js/jquery.min.js"></script>
         <script type="text/javascript" src="/js/app.js"></script>
        </body>
     </html>)

  def index = layout(<div>it works</div>)
}
