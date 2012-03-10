object Templates {
  import scala.xml._
  import unfiltered.response.Html
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
