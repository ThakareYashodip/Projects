import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:task_1/Utils/Essentials.dart';
import 'GradientText.dart';

class CustomCard extends StatelessWidget {
  final bool isEnable;
  final String name;
  const CustomCard({super.key, required this.isEnable, required this.name});

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.only(top: 10.h),
      height: 248.h,
      width: 364.w,
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(16.r),
        boxShadow: [
          BoxShadow(
            blurRadius: 12.r,
            blurStyle: BlurStyle.outer,
            color: Color.fromRGBO(0, 0, 0, 0.06),
          ),
        ],
      ),
      child: Padding(
        padding: EdgeInsets.symmetric(horizontal: 16.w, vertical: 8.h),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            Row(
              children: [
                customText(
                  name,
                  "Poppins",
                  16.sp,
                  FontWeight.w500,
                  Colors.black,
                ),
                SizedBox(width: 5.w),
                Icon(
                  Icons.arrow_forward_ios_outlined,
                  color: Colors.black,
                  size: 15.r,
                ),
              ],
            ),
            RichText(
              text: TextSpan(
                children: [
                  WidgetSpan(
                    child: GradientText(
                      "Earning Opportunity: Rs. 5,530  ",
                      style: TextStyle(
                        fontSize: 11.sp,
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
                  TextSpan(
                    text: "|  Sold: 5 Services so far",
                    style: TextStyle(
                      fontSize: 11.sp,
                      fontFamily: "Poppins",
                      fontWeight: FontWeight.w600,
                      color: const Color.fromRGBO(40, 40, 40, 0.8),
                    ),
                  ),
                ],
              ),
            ),
            Divider(
              thickness: 1.h,
              color: const Color.fromRGBO(40, 40, 40, 0.8),
            ),
            RichText(
              text: TextSpan(
                text: "SBI Prime  ",
                style: TextStyle(
                  fontSize: 14.sp,
                  fontFamily: "Poppins",
                  fontWeight: FontWeight.w500,
                  color: const Color.fromRGBO(40, 40, 40, 1),
                ),
                children: [
                  TextSpan(
                    text: "HDFC Premium",
                    style: TextStyle(
                      fontSize: 14.sp,
                      fontFamily: "Poppins",
                      fontWeight: FontWeight.w500,
                      color: const Color.fromRGBO(40, 40, 40, 0.8),
                    ),
                  ),
                ],
              ),
            ),
            Center(
              child: isEnable
                  ? Container(
                      width: 336.w,
                      height: 82.h,
                      margin: EdgeInsets.symmetric(vertical: 10.h),
                      padding: EdgeInsets.symmetric(
                        horizontal: 20.w,
                        vertical: 10.h,
                      ),
                      decoration: BoxDecoration(
                        borderRadius: BorderRadius.circular(8.r),
                        color: const Color.fromRGBO(255, 249, 242, 1),
                      ),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          customText(
                            "Customer Action Required",
                            "Poppins",
                            12.sp,
                            FontWeight.w500,
                            Colors.black,
                          ),
                          customText(
                            "Upload income proof to proceed with your application",
                            "Poppins",
                            12.sp,
                            FontWeight.w400,
                            const Color.fromRGBO(0, 0, 0, 0.7),
                          ),
                        ],
                      ),
                    )
                  : Container(
                      height: 93.h,
                      width: 336.w,
                      margin: EdgeInsets.symmetric(vertical: 10.h),
                      decoration: BoxDecoration(
                        borderRadius: BorderRadius.circular(8.r),
                        color: const Color.fromRGBO(0, 87, 216, 0.04),
                      ),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Row(
                            mainAxisAlignment: MainAxisAlignment.center,
                            children: [
                              Container(
                                height: 61.h,
                                width: 149.w,
                                padding: EdgeInsets.all(5.w),
                                decoration: BoxDecoration(
                                  border: const Border(
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
                                      12.sp,
                                      FontWeight.w400,
                                      const Color.fromRGBO(0, 0, 0, 0.7),
                                    ),
                                    customText(
                                      "21 August, 2025",
                                      "Poppins",
                                      13.sp,
                                      FontWeight.w500,
                                      const Color.fromRGBO(0, 0, 0, 0.9),
                                    ),
                                  ],
                                ),
                              ),
                              Container(
                                height: 61.h,
                                width: 149.w,
                                padding: EdgeInsets.all(5.w),
                                decoration: const BoxDecoration(
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
                                      12.sp,
                                      FontWeight.w400,
                                      const Color.fromRGBO(0, 0, 0, 0.7),
                                    ),
                                    customText(
                                      "28 August, 2025",
                                      "Poppins",
                                      13.sp,
                                      FontWeight.w500,
                                      const Color.fromRGBO(0, 0, 0, 0.9),
                                    ),
                                  ],
                                ),
                              ),
                            ],
                          ),
                          Padding(
                            padding: EdgeInsets.all(4.w),
                            child: customText(
                              "⚠️ Update from bank is delayed by 6 days",
                              "Poppins",
                              12.sp,
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
                          13.sp,
                          FontWeight.w500,
                          const Color.fromRGBO(0, 87, 216, 1),
                        ),
                        context,
                        Colors.white,
                      ),
                      customButtonWhite(
                        customText(
                          "Remind Customer",
                          "Poppins",
                          13.sp,
                          FontWeight.w500,
                          Colors.white,
                        ),
                        context,
                        const Color.fromRGBO(0, 87, 216, 1),
                      ),
                    ],
                  )
                : customButton3(
                    customText(
                      "View Details",
                      "Poppins",
                      13.sp,
                      FontWeight.w500,
                      const Color.fromRGBO(0, 87, 216, 1),
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
