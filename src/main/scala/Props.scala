
object Props {
  private lazy val props = {
    val file = getClass.getResourceAsStream("/app.properties")
    val props = new java.util.Properties
    props.load(file)
    file.close()
    props
  }

  def get(k: String) = Option(props.getProperty("mu.apikey"))
}
