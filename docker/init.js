db.auth('tomgal', 'baza12')
db = db.getSiblingDB('blog')

for (var i=1; i <= 10; i++) {
  db.article.insert(
    {
      "title": "Article" + i,
      "category": "SOFTWARE_DEVELOPMENT",
      "visibility": "PUBLIC",
      "content": "content " + i,
      "timestamp": "2021-10-12T07:50:09.519277",
      "author": "tomgal",
      "_class": "ArticleEntity"
    }
  );
}

