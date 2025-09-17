import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:task_1/Screens/Screen3.dart';
import 'package:task_1/Utils/CustomCard.dart';
import 'package:task_1/Utils/Essentials.dart';

import '../Utils/GradientText.dart';

class Screen2 extends StatefulWidget {
  const Screen2({super.key});

  static const List<Map<String, dynamic>> statuses = [
    {"label": "Actionable", "count": 3},
    {"label": "Pending", "count": 2},
    {"label": "Rejected", "count": 1},
    {"label": "Activated", "count": 0},
  ];

  @override
  State<Screen2> createState() => _Screen2State();
}

class _Screen2State extends State<Screen2> {
  int selectedIndex = 0;
  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 3,
      child: Scaffold(
        backgroundColor: const Color.fromRGBO(246, 249, 255, 1),
        appBar: AppBar(
          backgroundColor: const Color.fromRGBO(246, 249, 255, 1),
          elevation: 0,
          leading: IconButton(
            onPressed: () => Navigator.pop(context),
            icon: const Icon(Icons.arrow_back, color: Colors.black),
          ),
          title: customText(
            "Leads",
            "Poppins",
            18,
            FontWeight.w500,
            Colors.black,
          ),
          centerTitle: false,
          toolbarHeight: 50,
          actions: [
            GestureDetector(
              onTap: () => Navigator.push(
                context,
                MaterialPageRoute(builder: (_) => Screen3()),
              ),
              child: customText(
                "Lead Guide",
                "Poppins",
                14,
                FontWeight.w500,
                const Color.fromRGBO(0, 87, 216, 1),
              ),
            ),
            const SizedBox(width: 4),
            const Icon(
              Icons.play_circle_fill,
              color: Color.fromRGBO(0, 78, 196, 1),
              size: 18,
            ),
            const SizedBox(width: 10),
          ],
        ),
        body: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            children: [
              // Searchbar
              Container(
                height: 38.h,
                width: 365.w,
                decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.circular(8),
                  border: Border.all(color: Colors.grey.shade300),
                ),
                child: const TextField(
                  decoration: InputDecoration(
                    hintText: "Search By Name",
                    prefixIcon: Icon(Icons.search),
                    border: InputBorder.none,
                  ),
                ),
              ),

              TabBar(
                labelColor: Colors.black, // selected
                unselectedLabelColor: const Color.fromARGB(
                  255,
                  78,
                  78,
                  78,
                ), //unselectedd
                isScrollable: true,
                indicatorSize: TabBarIndicatorSize.tab,
                indicatorColor: const Color.fromRGBO(0, 87, 216, 1),
                labelStyle: const TextStyle(
                  fontSize: 14,
                  fontFamily: "Poppins",
                  fontWeight: FontWeight.w500,
                ),
                unselectedLabelStyle: const TextStyle(
                  fontSize: 14,
                  fontFamily: "Poppins",
                  fontWeight: FontWeight.w300,
                ),
                tabs: const [
                  Tab(
                    child: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Text("Credit Cards"),
                        SizedBox(width: 6),
                        CircleAvatar(
                          radius: 10,
                          backgroundColor: Colors.red,
                          child: Text(
                            "20",
                            style: TextStyle(fontSize: 12, color: Colors.white),
                          ),
                        ),
                      ],
                    ),
                  ),
                  Tab(
                    child: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Text("Savings A/C"),
                        SizedBox(width: 6),
                        CircleAvatar(
                          radius: 10,
                          backgroundColor: Colors.grey,
                          child: Text(
                            "10",
                            style: TextStyle(fontSize: 12, color: Colors.white),
                          ),
                        ),
                      ],
                    ),
                  ),
                  Tab(
                    child: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Text("Demat A/C"),
                        SizedBox(width: 6),
                        CircleAvatar(
                          radius: 10,
                          backgroundColor: Colors.grey,
                          child: Text(
                            "10",
                            style: TextStyle(fontSize: 12, color: Colors.white),
                          ),
                        ),
                      ],
                    ),
                  ),
                ],
              ),

              // Tab Views
              Expanded(
                child: TabBarView(
                  children: [
                    SingleChildScrollView(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          SizedBox(
                            height: 50,
                            child: ListView.builder(
                              scrollDirection: Axis.horizontal,
                              itemCount: Screen2.statuses.length,
                              itemBuilder: (context, index) {
                                final item = Screen2.statuses[index];
                                final bool isSelected = selectedIndex == index;

                                return GestureDetector(
                                  onTap: () {
                                    setState(() {
                                      selectedIndex = index;
                                    });
                                  },
                                  child: Container(
                                    margin: const EdgeInsets.symmetric(
                                      horizontal: 6,
                                      vertical: 8,
                                    ),
                                    padding: const EdgeInsets.symmetric(
                                      horizontal: 14,
                                      vertical: 6,
                                    ),
                                    decoration: BoxDecoration(
                                      color: isSelected
                                          ? const Color.fromRGBO(
                                              0,
                                              87,
                                              216,
                                              0.1,
                                            ) // selected bg
                                          : const Color.fromRGBO(0, 0, 0, 0.1),
                                      borderRadius: BorderRadius.circular(20),
                                    ),
                                    child: Center(
                                      child: Text(
                                        "${item["label"]} (${item["count"]})",
                                        style: TextStyle(
                                          fontSize: 14,
                                          fontWeight: FontWeight.w500,
                                          color: isSelected
                                              ? const Color.fromRGBO(
                                                  0,
                                                  87,
                                                  216,
                                                  1,
                                                )
                                              : const Color.fromRGBO(
                                                  0,
                                                  0,
                                                  0,
                                                  0.5,
                                                ),
                                        ),
                                      ),
                                    ),
                                  ),
                                );
                              },
                            ),
                          ),
                          //
                          CustomCard(isEnable: true, name: "Sarish Patil"),
                          CustomCard(isEnable: true, name: "Ajay Potdar"),
                          CustomCard(isEnable: false, name: "Akshata Kenjale"),
                          CustomCard(isEnable: false, name: "Ninganna"),
                        ],
                      ),
                    ),

                    const Center(child: Text("🔥 Saving A/C Tab Content")),
                    const Center(child: Text("✅ Demat A/C Tab Content")),
                  ],
                ),
              ),
            ],
          ),
        ),
        bottomNavigationBar: Container(
          padding: EdgeInsets.symmetric(horizontal: 16, vertical: 8),
          height: 60,
          color: Colors.white,
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              customText(
                "Facing an issue? Tap for help.",
                "Poppins",
                14,
                FontWeight.w400,
                const Color.fromRGBO(40, 40, 40, 0.8),
              ),
              Container(
                height: 35,
                width: 150,
                decoration: BoxDecoration(
                  color: Color.fromRGBO(51, 51, 51, 1),
                  borderRadius: BorderRadius.circular(8),
                ),
                child: Center(
                  child: customText(
                    "Need Help",
                    "Inter",
                    14,
                    FontWeight.w500,
                    Colors.white,
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

// class _TabWithBadge extends StatelessWidget {
//   final String title;
//   final String value;

//   const _TabWithBadge({required this.title, required this.value});

//   @override
//   Widget build(BuildContext context) {
//     final TabBarThemeData tabTheme = TabBarTheme.of(context);
//     final bool selected =
//         DefaultTextStyle.of(context).style.color == tabTheme.labelColor;

//     return Row(
//       mainAxisSize: MainAxisSize.min,
//       children: [
//         Text(title),
//         const SizedBox(width: 6),
//         CircleAvatar(
//           radius: 10,
//           backgroundColor: selected
//               ? Colors.red
//               : Colors.grey, // ✅ simple logic
//           child: Text(
//             value,
//             style: const TextStyle(fontSize: 12, color: Colors.white),
//           ),
//         ),
//       ],
//     );
//   }
// }
