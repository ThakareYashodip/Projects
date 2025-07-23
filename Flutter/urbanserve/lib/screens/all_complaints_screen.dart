import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:intl/intl.dart';
import 'package:urbanserve/controller/bottom_navbar.dart';
import 'package:urbanserve/controller/complaint_controller.dart';
import 'package:urbanserve/screens/complaint_listing_screen.dart';

class ComplaintsListScreen extends StatelessWidget {
  ComplaintsListScreen({super.key});
  final ComplaintRegisterController controller = Get.put(
    ComplaintRegisterController(),
  );

  final BottomNavController bottomNavController = Get.put(
    BottomNavController(),
  );

  // Sample complaints data

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFF8FAFC),
      body: CustomScrollView(
        slivers: [
          // 🔹 SliverAppBar
          _buildSilverAppBar(context),

          // 🔹 Stats Card Section
          SliverToBoxAdapter(
            child: Container(
              margin: const EdgeInsets.all(16),
              padding: const EdgeInsets.all(20),
              decoration: BoxDecoration(
                gradient: const LinearGradient(
                  begin: Alignment.topLeft,
                  end: Alignment.bottomRight,
                  colors: [Color(0xFF4F46E5), Color(0xFF7C3AED)],
                ),
                borderRadius: BorderRadius.circular(16),
                boxShadow: [
                  BoxShadow(
                    color: const Color(0xFF4F46E5).withOpacity(0.3),
                    blurRadius: 20,
                    offset: const Offset(0, 8),
                  ),
                ],
              ),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: [
                  _buildStatItem(
                    'Total',
                    '${controller.complaintsCount}',
                    Icons.receipt_long,
                  ),
                  _buildStatItem('Open', '${controller.openCount}', Icons.sync),
                  _buildStatItem(
                    'Resolved',
                    '${controller.resolvedCount}',
                    Icons.check_circle,
                  ),
                ],
              ),
            ),
          ),

          // 🔹 Filter Chips
          SliverToBoxAdapter(
            child: SingleChildScrollView(
              scrollDirection: Axis.horizontal,
              padding: const EdgeInsets.symmetric(horizontal: 16),
              child: Row(
                children: [
                  _buildFilterChip('All', true),
                  _buildFilterChip('High Priority', false),
                  _buildFilterChip('Pending', false),
                  _buildFilterChip('Infrastructure', false),
                  _buildFilterChip('Recent', false),
                ],
              ),
            ),
          ),

          // 🔹 Complaints List
          SliverList(
            delegate: SliverChildBuilderDelegate((context, index) {
              final complaint = controller.complaints[index];
              return _buildComplaintCard(
                complaint,
                index,
                context,
                onTap: () {
                  Get.to(() => ComplaintDetailScreen(index)); // ✅ index passed
                },
              );
            }, childCount: controller.complaints.length),
          ),

          // Optional spacing at bottom
          SliverToBoxAdapter(child: SizedBox(height: 24)),
        ],
      ),
      floatingActionButton: FloatingActionButton.extended(
        onPressed: () {
          bottomNavController.changeIndex(1);
          Get.back();
        },
        backgroundColor: const Color(0xFF4F46E5),
        icon: const Icon(Icons.add, color: Colors.white),
        label: const Text(
          'New Complaint',
          style: TextStyle(color: Colors.white, fontWeight: FontWeight.w600),
        ),
      ),
    );
  }

  Widget _buildSilverAppBar(BuildContext context) {
    return SliverAppBar(
      pinned: true,
      floating: false,
      expandedHeight: 120,
      backgroundColor: Colors.transparent,
      elevation: 0,
      automaticallyImplyLeading: false,
      flexibleSpace: Container(
        decoration: const BoxDecoration(
          gradient: LinearGradient(
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
            colors: [Color(0xFF667EEA), Color(0xFF764BA2)],
          ),
        ),
        child: FlexibleSpaceBar(
          titlePadding: const EdgeInsets.only(left: 20, bottom: 16),
          title: Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Container(
                padding: const EdgeInsets.all(8),
                decoration: BoxDecoration(
                  color: Colors.white.withOpacity(0.2),
                  borderRadius: BorderRadius.circular(12),
                ),
                child: const Icon(
                  Icons.report_problem_outlined,
                  color: Colors.white,
                  size: 16,
                ),
              ),
              Text(
                "All Complaints",
                style: GoogleFonts.inter(
                  color: Colors.white,
                  fontWeight: FontWeight.w700,
                  fontSize: 18,
                ),
              ),
              const Spacer(),
              Row(
                children: [
                  IconButton(
                    onPressed: () {},
                    icon: const Icon(
                      Icons.filter_list,
                      color: Colors.white,
                      size: 16,
                    ),
                  ),
                  IconButton(
                    onPressed: () {},
                    icon: const Icon(
                      Icons.search,
                      color: Colors.white,
                      size: 16,
                    ),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildStatItem(String title, String value, IconData icon) {
    return Column(
      children: [
        Container(
          padding: const EdgeInsets.all(8),
          decoration: BoxDecoration(
            color: Colors.white.withOpacity(0.2),
            borderRadius: BorderRadius.circular(8),
          ),
          child: Icon(icon, color: Colors.white, size: 20),
        ),
        const SizedBox(height: 8),
        Text(
          value,
          style: const TextStyle(
            color: Colors.white,
            fontSize: 18,
            fontWeight: FontWeight.bold,
          ),
        ),
        Text(
          title,
          style: TextStyle(color: Colors.white.withOpacity(0.8), fontSize: 12),
        ),
      ],
    );
  }

  Widget _buildFilterChip(String label, bool isSelected) {
    return Container(
      margin: const EdgeInsets.only(right: 8),
      child: FilterChip(
        label: Text(label),
        selected: isSelected,
        onSelected: (bool selected) {},
        backgroundColor: Colors.white,
        selectedColor: const Color(0xFF4F46E5).withOpacity(0.1),
        checkmarkColor: const Color(0xFF4F46E5),
        labelStyle: TextStyle(
          color: isSelected ? const Color(0xFF4F46E5) : const Color(0xFF64748B),
          fontWeight: isSelected ? FontWeight.w600 : FontWeight.normal,
        ),
        side: BorderSide(
          color: isSelected ? const Color(0xFF4F46E5) : const Color(0xFFE2E8F0),
        ),
      ),
    );
  }

  Widget _buildComplaintCard(
    Map<String, dynamic> complaint,
    int index,
    BuildContext context, {
    VoidCallback? onTap,
  }) {
    final status = complaint['status'] as String;
    final title = complaint['title'] as String;
    final description = complaint['description'] as String;
    final createdAt = complaint['createdAt'] as String;
    String formattedDate = DateFormat(
      'MMM d, yyyy • hh:mm a',
    ).format(DateTime.parse(createdAt));

    return Container(
      margin: const EdgeInsets.only(bottom: 16),
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(16),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withOpacity(0.05),
            blurRadius: 10,
            offset: const Offset(0, 4),
          ),
        ],
      ),
      child: InkWell(
        onTap: onTap ?? () {},
        borderRadius: BorderRadius.circular(16),
        child: Padding(
          padding: const EdgeInsets.all(16),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // Header Row
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Chip(
                    label: Text("ID: ${complaint['id']}"),
                    backgroundColor: _getStatusColor(status).withOpacity(0.1),
                    labelStyle: TextStyle(
                      color: _getStatusColor(status),
                      fontWeight: FontWeight.w600,
                    ),
                  ),
                  Chip(
                    label: Text(status),
                    backgroundColor: _getStatusColor(status),
                    labelStyle: const TextStyle(
                      color: Colors.white,
                      fontWeight: FontWeight.w600,
                    ),
                  ),
                ],
              ),

              const SizedBox(height: 12),

              // Title
              Text(
                title,
                style: const TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.bold,
                  color: Color(0xFF1E293B),
                ),
              ),

              const SizedBox(height: 8),

              // Description
              Text(
                description,
                style: const TextStyle(
                  fontSize: 14,
                  color: Color(0xFF64748B),
                  height: 1.4,
                ),
                maxLines: 3,
                overflow: TextOverflow.ellipsis,
              ),

              const SizedBox(height: 12),

              // Footer Row
              Row(
                children: [
                  const Icon(
                    Icons.access_time,
                    size: 16,
                    color: Color(0xFF64748B),
                  ),
                  const SizedBox(width: 4),
                  Text(
                    formattedDate,
                    style: const TextStyle(
                      fontSize: 12,
                      color: Color(0xFF64748B),
                    ),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }

  Color _getStatusColor(String status) {
    switch (status) {
      case 'OPEN':
        return const Color(0xFFD97706);
      case 'RESOLVED':
        return const Color(0xFF10B981);
      default:
        return const Color.fromARGB(255, 178, 189, 209);
    }
  }

  String _getStatusText(String status) {
    switch (status) {
      case 'PENDING':
        return 'PENDING';
      case 'RESOLVED':
        return 'RESOLVED';
      default:
        return 'UNKNOWN';
    }
  }

  Color _getPriorityColor(String priority) {
    switch (priority) {
      case 'high':
        return const Color(0xFFEF4444);
      case 'medium':
        return const Color(0xFFF59E0B);
      case 'low':
        return const Color(0xFF10B981);
      default:
        return const Color(0xFF6B7280);
    }
  }

  IconData _getPriorityIcon(String priority) {
    switch (priority) {
      case 'high':
        return Icons.keyboard_arrow_up;
      case 'medium':
        return Icons.remove;
      case 'low':
        return Icons.keyboard_arrow_down;
      default:
        return Icons.remove;
    }
  }
}
