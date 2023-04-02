class UserInfoModel {
  String? city;
  String? memberNumberInHome;
  String? job;
  int? annualSalary;
  String? civilStatus;
  String? username;

  UserInfoModel(
      {this.city,
      this.memberNumberInHome,
      this.job,
      this.annualSalary,
      this.civilStatus,
      this.username});

  UserInfoModel.fromJson(Map<String, dynamic> json) {
    city = json['city'];
    memberNumberInHome = json['memberNumberInHome'];
    job = json['job'];
    annualSalary = json['annualSalary'];
    civilStatus = json['civilStatus'];
    username = json['username'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['city'] = this.city;
    data['memberNumberInHome'] = this.memberNumberInHome;
    data['job'] = this.job;
    data['annualSalary'] = this.annualSalary;
    data['civilStatus'] = this.civilStatus;
    data['username'] = this.username;
    return data;
  }
}
