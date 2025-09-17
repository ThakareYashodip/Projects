import 'package:flutter/material.dart';
import 'package:task_1/Utils/Essentials.dart';
import 'GradientText.dart';

class CustomCard extends StatelessWidget {
  final bool isEnable;
  final String name ;
  const CustomCard({super.key, required this.isEnable, required this.name});

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.all(16),
      height: 250,
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(16),
        boxShadow: [
          BoxShadow(
            blurRadius: 12,
            blurStyle: BlurStyle.outer,
            color: Color.fromRGBO(0, 0, 0, 0.06),
          ),
        ],
      ),
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 18, vertical: 8),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            Row(
              children: [
                customText(
                  name,
                  "Poppins",
                  16,
                  FontWeight.w500,
                  Colors.black,
                ),
                const SizedBox(width: 5),
                Icon(
                  Icons.arrow_forward_ios_outlined,
                  color: Colors.black,
                  size: 15,
                ),
              ],
            ),
            RichText(
              text: TextSpan(
                children: [
                  WidgetSpan(
                    child: GradientText(
                      "Earning Opportunity: Rs. 5,530  ",
                      style: const TextStyle(
                        fontSize: 11,
                        fontFamily: "Poppins",
                        fontWeight: FontWeight.w500,
                      ),
                      gradient: const LinearGradient(
                        begin: Alignment.centerLeft,
                        end: Alignment.centerRight,
                        colors: [
                          Color(0xFFC6951A),
                          Color(0xFFFFEC9E),
                          Color(0xFFC6951A),
                        ],
                        stops: [0.0, 0.5, 1.0],
                      ),
                    ),
                  ),
                  const TextSpan(
                    text: "|  Sold: 5 Services so far",
                    style: TextStyle(
                      fontSize: 11,
                      fontFamily: "Poppins",
                      fontWeight: FontWeight.w600,
                      color: Color.fromRGBO(40, 40, 40, 0.8),
                    ),
                  ),
                ],
              ),
            ),

            Divider(thickness: 1, color: Color.fromRGBO(40, 40, 40, 0.8)),
            RichText(
              text: const TextSpan(
                text: "SBI Prime  ",
                style: TextStyle(
                  fontSize: 14,
                  fontFamily: "Poppins",
                  fontWeight: FontWeight.w500,
                  color: Color.fromRGBO(40, 40, 40, 1),
                ),
                children: [
                  TextSpan(
                    text: "HDFC Premium",
                    style: TextStyle(
                      fontSize: 14,
                      fontFamily: "Poppins",
                      fontWeight: FontWeight.w500,
                      color: Color.fromRGBO(40, 40, 40, 0.8),
                    ),
                  ),
                ],
              ),
            ),
            Center(
              child: Container(
                width: 350,
                height: 100,
                margin: EdgeInsets.symmetric(vertical: 10),
                padding: isEnable
                    ? EdgeInsets.symmetric(horizontal: 25, vertical: 20)
                    : null,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(16),
                  color: isEnable
                      ? Color.fromRGBO(255, 249, 242, 1)
                      : Color.fromRGBO(0, 87, 216, 0.04),
                ),
                child: isEnable
                    ? Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          customText(
                            "Customer Action Required",
                            "Poppins",
                            12,
                            FontWeight.w500,
                            Colors.black,
                          ),
                          customText(
                            "Upload income proof to proceed with your application",
                            "Poppins",
                            12,
                            FontWeight.w400,
                            const Color.fromRGBO(0, 0, 0, 0.7),
                          ),
                        ],
                      )
                    : Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Row(
                            mainAxisAlignment: MainAxisAlignment.center,
                            children: [
                              Container(
                                height: 60,
                                width: 170,
                                padding: EdgeInsets.all(10),
                                decoration: BoxDecoration(
                                  border: Border(
                                    bottom: BorderSide(color: Colors.black12),
                                    right: BorderSide(color: Colors.black12),
                                  ),
                                ),
                                child: Column(
                                  mainAxisAlignment:
                                      MainAxisAlignment.spaceEvenly,
                                  children: [
                                    customText(
                                      "Bank Last updated on",
                                      "Poppins",
                                      12,
                                      FontWeight.w400,
                                      const Color.fromRGBO(0, 0, 0, 0.7),
                                    ),
                                    customText(
                                      "21 August, 2025",
                                      "Poppins",
                                      13,
                                      FontWeight.w500,
                                      const Color.fromRGBO(0, 0, 0, 0.9),
                                    ),
                                  ],
                                ),
                              ),
                              Container(
                                height: 60,
                                width: 170,
                                padding: EdgeInsets.all(10),
                                decoration: BoxDecoration(
                                  border: Border(
                                    bottom: BorderSide(color: Colors.black12),
                                  ),
                                ),
                                child: Column(
                                  mainAxisAlignment:
                                      MainAxisAlignment.spaceEvenly,
                                  children: [
                                    customText(
                                      "Expected Next Update",
                                      "Poppins",
                                      12,
                                      FontWeight.w400,
                                      const Color.fromRGBO(0, 0, 0, 0.7),
                                    ),
                                    customText(
                                      "28 August, 2025",
                                      "Poppins",
                                      13,
                                      FontWeight.w500,
                                      const Color.fromRGBO(0, 0, 0, 0.9),
                                    ),
                                  ],
                                ),
                              ),
                            ],
                          ),
                          Padding(
                            padding: EdgeInsetsGeometry.all(10),
                            child: customText(
                              "⚠️ Update from bank is delayed by 6 days",
                              "Poppins",
                              12,
                              FontWeight.w400,
                              const Color.fromRGBO(0, 0, 0, 0.7),
                            ),
                          ),
                        ],
                      ),
              ),
            ),
            isEnable
                ? Row(
                    mainAxisAlignment: MainAxisAlignment.spaceAround,
                    children: [
                      customButtonWhite(
                        customText(
                          "View Details",
                          "Poppins",
                          13,
                          FontWeight.w500,
                          Color.fromRGBO(0, 87, 216, 1),
                        ),
                        context,
                        Colors.white,
                      ),
                      customButtonWhite(
                        customText(
                          "Remind Customers",
                          "Poppins",
                          13,
                          FontWeight.w500,
                          Colors.white,
                        ),
                        context,
                        Color.fromRGBO(0, 87, 216, 1),
                      ),
                    ],
                  )
                : customButton3(
                    customText(
                      "View Details",
                      "Poppins",
                      13,
                      FontWeight.w500,
                      Color.fromRGBO(0, 87, 216, 1),
                    ),
                    context,
                    Colors.white,
                  ),
          ],
        ),
      ),
    );
  }
}
