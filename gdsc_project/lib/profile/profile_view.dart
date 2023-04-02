import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:gdsc_project/models/user_info_model.dart';
import '../models/feed_model.dart';
import './profile_view_model.dart';

class ProfileView extends ProfileViewModel {
  UserInfoModel? _informations;
  List? _userPosts;
  List _ids = [];
  final List<String> entries = <String>[
    'Washing Machine',
    'Dishwasher',
    'Energy Consumption',
    'Kitchen',
    'Personal Hygiene',
    'Rubbish',
    'Vacuum Cleaner'
  ];

  final List<String> urls = <String>[
    'https://forms.gle/zg63bMQWZvx8a8G18',
    'https://forms.gle/1RfmBLjSuPpQTx6X7',
    'https://forms.gle/A1Yunt7eomjkPrsP7',
    'https://forms.gle/GFLDqoZnh1DynBUT7',
    'https://forms.gle/D2WmqmBFRVtQcPec8',
    'https://forms.gle/6Soc6it1NrFiwFuEA',
    'https://forms.gle/4EFqhRqxgb2ELHPj8'
  ];

  int checkIndex(String? category) {
    if (category == 'Washing Machine') {
      return 0;
    }
    if (category == 'Dishwasher') {
      return 1;
    }
    if (category == 'Energy Consumption') {
      return 2;
    }
    if (category == 'Kitchen') {
      return 3;
    }
    if (category == 'Personal Hygiene') {
      return 4;
    }
    if (category == 'Rubbish') {
      return 5;
    }
    if (category == 'Vacuum Cleaner') {
      return 6;
    } else {
      return 0;
    }
  }

  final List<String> icons = [
    'assets/washing_machine.png',
    'assets/dishwasher.png',
    'assets/energy.png',
    'assets/kitchen.png',
    'assets/hygiene.png',
    'assets/garbage.png',
    'assets/vacuum_cleaner.png'
  ];
  Future<void> assigningInfo() async {
    var info = await getUserInfo();
    setState(() {
      _informations = info;
    });
  }

  Future<void> assigningPost() async {
    var posts = await getUserPosts();
    setState(() {
      _userPosts = posts;
    });
  }

  @override
  void initState() {
    super.initState();
    assigningInfo();
    assigningPost();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: primColor(),
      appBar: AppBar(
          toolbarHeight: 100,
          backgroundColor: primColor(),
          title: Image.asset('assets/old.png', scale: 1.5, fit: BoxFit.cover)),
      body: Center(
        child: SingleChildScrollView(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Container(
                    alignment: Alignment.centerLeft,
                    padding: const EdgeInsets.only(left: 30),
                    color: primColor(),
                    height: 180,
                    width: 300,
                    child: Text(
                      _informations?.username ?? '',
                      style: TextStyle(fontSize: 35),
                    ),
                  ),
                  Container(
                    color: primColor(),
                    height: 180,
                    width: 200,
                    padding: const EdgeInsets.only(right: 30),
                    child: Column(
                      children: [
                        const SizedBox(
                          height: 30,
                        ),
                        const Align(
                          alignment: Alignment.centerRight,
                          child: Icon(
                            CupertinoIcons.profile_circled,
                            size: 100,
                            color: Colors.black,
                          ),
                        ),
                        Row(
                          mainAxisAlignment: MainAxisAlignment.end,
                          children: const [
                            Text('Edit Profile '),
                            Icon(Icons.edit),
                          ],
                        )
                      ],
                    ),
                  )
                ],
              ),
              const HorizontalOrLine(
                label: 'Information',
                height: 30,
                icon: CupertinoIcons.info_circle_fill,
              ),
              Container(
                color: primColor(),
                height: 200,
                width: 500,
                child: Center(
                  child: Column(children: [
                    Informations(label: 'City', info: _informations?.city),
                    const SizedBox(
                      height: 10,
                    ),
                    Informations(
                        label: 'Resident Count',
                        info: _informations?.memberNumberInHome),
                    const SizedBox(
                      height: 10,
                    ),
                    Informations(label: 'Profession', info: _informations?.job),
                    const SizedBox(
                      height: 10,
                    ),
                    Informations(
                        label: 'Salary',
                        info:
                            _informations?.annualSalary.toString() ?? 'error'),
                    const SizedBox(
                      height: 10,
                    ),
                    Informations(
                        label: 'Marital Status',
                        info: _informations?.civilStatus ?? 'error'),
                  ]),
                ),
              ),
              const HorizontalOrLine(
                  label: 'Add Data',
                  height: 30,
                  icon: CupertinoIcons.add_circled_solid),
              GridView.builder(
                  gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                      crossAxisCount: 2,
                      mainAxisSpacing: 30,
                      crossAxisSpacing: 40,
                      mainAxisExtent: 50),
                  itemCount: entries.length,
                  scrollDirection: Axis.vertical,
                  shrinkWrap: true,
                  padding: const EdgeInsets.all(25),
                  itemBuilder: (_, index) {
                    return InkWell(
                      onTap: () {},
                      child: Ink(
                        height: 15,
                        width: 10,
                        decoration: BoxDecoration(
                            color: checkInfo(entries[index], _userPosts)
                                ? Colors.green
                                : Colors.black,
                            borderRadius: BorderRadius.circular(20)),
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            checkInfo(entries[index], _userPosts)
                                ? const Icon(
                                    CupertinoIcons.check_mark,
                                    color: Colors.white,
                                  )
                                : const Icon(
                                    CupertinoIcons.add,
                                    color: Colors.white,
                                  ),
                            const Text('  '),
                            Text(
                              entries[index],
                              style: const TextStyle(
                                  color: Colors.white, fontSize: 18),
                            ),
                          ],
                        ),
                      ),
                    );
                  }),
              const HorizontalOrLine(
                label: 'Your Posts',
                height: 50,
                icon: CupertinoIcons.bookmark_fill,
              ),
              ListView.separated(
                scrollDirection: Axis.vertical,
                shrinkWrap: true,
                padding: const EdgeInsets.all(40),
                itemCount: _userPosts?.length ?? 0,
                itemBuilder: (BuildContext context, index) {
                  return Container(
                      padding: EdgeInsets.all(18),
                      decoration: BoxDecoration(
                          border: Border.all(width: 2),
                          color: Color.fromARGB(255, 255, 255, 249),
                          borderRadius: BorderRadius.circular(20)),
                      child: Expanded(
                          child: Column(children: <Widget>[
                        Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: [
                            Image.asset(
                              icons[checkIndex(
                                  _userPosts?[index]['category'] ?? '')],
                              scale: 4,
                            ),
                            const SizedBox(
                              width: 10,
                            ),
                            Container(
                                child: Expanded(
                              child: Column(
                                mainAxisSize: MainAxisSize.min,
                                children: [
                                  Flexible(
                                    child: Row(
                                      mainAxisAlignment:
                                          MainAxisAlignment.spaceBetween,
                                      children: [
                                        Text(_informations?.username ?? '',
                                            style: const TextStyle(
                                                fontSize: 25,
                                                fontWeight: FontWeight.bold)),
                                        Text(
                                            _userPosts?[index]['category'] ??
                                                '',
                                            style: const TextStyle(
                                                fontSize: 20,
                                                fontWeight: FontWeight.bold)),
                                      ],
                                    ),
                                  ),
                                  const SizedBox(
                                    height: 25,
                                  ),
                                  Explanation(
                                    index: index,
                                    posts: _userPosts,
                                  ),
                                ],
                              ),
                            )),
                            const SizedBox(
                              width: 10,
                            )
                          ],
                        ),
                        const SizedBox(
                          height: 15,
                        ),
                        Align(
                          alignment: Alignment.centerRight,
                          child: ElevatedButton(
                              onPressed: () async {
                                var enter = await deleteUserPost(
                                    _userPosts?[index]['id']);
                                if (enter == true) {
                                  setState(() {
                                    assigningPost();
                                  });
                                } else {
                                  showSnackBar(context);
                                }
                              },
                              style: ElevatedButton.styleFrom(
                                  minimumSize: Size(25, 50),
                                  backgroundColor: Colors.red),
                              child: const Text(
                                'Delete',
                                style: TextStyle(fontSize: 20),
                              )),
                        )
                      ])));
                },
                separatorBuilder: (BuildContext context, int index) =>
                    const Divider(
                  thickness: 5,
                  color: Colors.black26,
                  height: 50,
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}

class Informations extends StatelessWidget {
  const Informations({super.key, required this.label, required this.info});

  final String label;
  final String? info;

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Text(
          '$label:',
          style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 25),
        ),
        Text(
          info ?? '',
          style: const TextStyle(fontSize: 25),
        )
      ],
    );
  }
}

class HorizontalOrLine extends StatelessWidget {
  const HorizontalOrLine({
    super.key,
    required this.label,
    required this.height,
    required this.icon,
  });

  final String label;
  final double height;
  final IconData icon;

  @override
  Widget build(BuildContext context) {
    return Row(children: <Widget>[
      Expanded(
        child: Container(
            margin: const EdgeInsets.only(left: 10.0, right: 15.0),
            child: Divider(
              thickness: 5.0,
              color: Colors.black,
              height: height,
            )),
      ),
      Text(
        '$label  ',
        style: const TextStyle(fontSize: 25),
      ),
      Icon(
        icon,
        size: 25,
      ),
      Expanded(
        child: Container(
            margin: const EdgeInsets.only(left: 15.0, right: 10.0),
            child: Divider(
              thickness: 5.0,
              color: Colors.black,
              height: height,
            )),
      ),
    ]);
  }
}

class Explanation extends StatelessWidget {
  const Explanation({super.key, required this.posts, required this.index});

  final List? posts;
  final int index;

  @override
  Widget build(BuildContext context) {
    return SelectableText(posts?[index]['explanation'] ?? '',
        textAlign: TextAlign.start,
        style: TextStyle(
          fontSize: 17.5,
        ));
  }
}
