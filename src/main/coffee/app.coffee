$ = jQuery
$ ->
  render = (m) ->
    console.log m
    "<div><img src='#{m.member_photo.photo_link}'></div>"
  handle = (data) ->
    console.log(data)
    if(data and data.results)
      (render(r) for r in data.results).join("")
    return
  $.getJSON "/rsvps", (data) ->
    console.log data
    handle data
    return
