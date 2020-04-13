function getList(domain, subDomain) {
  $('.challenge-list-item').each(function (index) {
    var item = $(this)
    var title = item.find('.challengecard-title')
      .clone()
      .children()
      .remove()
      .end()
      .text()
    var difficulty = item.find(".difficulty").text();
    var score = item.find(".max-score").text().replace("Max Score: ", "");
    var link = "https://www.hackerrank.com" + item.attr("href");
    console.log(
      "|" +subDomain+ "|[" +title+ "](" +link+ ")|" +difficulty+ "|" +score+ "|[Solution.java](" +domain+ "/" +subDomain+ "/" +title+ "/Solution.java)|"
    )
  })
}
