class PostModel {
  String? explanation;
  String? category;
  int? likeCount;
  String? username;
  int? id;
  String? createdAt;
  Content? content;

  PostModel(
      {this.explanation,
      this.category,
      this.likeCount,
      this.username,
      this.id,
      this.createdAt,
      this.content});

  PostModel.fromJson(Map<String, dynamic> json) {
    explanation = json['explanation'];
    category = json['category'];
    likeCount = json['likeCount'];
    username = json['username'];
    id = json['id'];
    createdAt = json['createdAt'];
    content =
        json['content'] != null ? new Content.fromJson(json['content']) : null;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['explanation'] = this.explanation;
    data['category'] = this.category;
    data['likeCount'] = this.likeCount;
    data['username'] = this.username;
    data['id'] = this.id;
    data['createdAt'] = this.createdAt;
    if (this.content != null) {
      data['content'] = this.content!.toJson();
    }
    return data;
  }
}

class Content {
  final Map<dynamic, dynamic> data;

  Content(this.data);

  factory Content.fromJson(dynamic json) {
    assert(json is Map);
    return Content(json['content']);
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    return data;
  }
}
