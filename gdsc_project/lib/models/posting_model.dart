class PostingModel {
  String? category;
  String? explanation;
  String? timeCreated;

  PostingModel({this.category, this.explanation, this.timeCreated});

  PostingModel.fromJson(Map<String, dynamic> json) {
    category = json['category'];
    explanation = json['explanation'];
    timeCreated = json['timeCreated'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['category'] = this.category;
    data['explanation'] = this.explanation;
    data['timeCreated'] = this.timeCreated;
    return data;
  }
}
