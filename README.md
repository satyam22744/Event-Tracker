# Event Budget & Vendor Payment Tracker

A simple, menu-driven console application written in Java to manage event budgets, track vendor contracts, and record installment payments.

## Features

- **Set & Update Total Budget:** Define an overall budget for your event and adjust it anytime.
- **Add Vendors:** Record vendor details including their name, service category (e.g., Food, Sound, Decor), total bill amount, and any initial advance paid.
- **Record Vendor Payments:** Select a vendor from the list to log partial or full payments, with built-in checks to prevent overpaying.
- **Budget & Vendor Dashboard:** View a complete breakdown of all vendors, their payment status (`Paid` or `Pending`), total committed expenses, remaining budget, and automatic over-budget warnings.

## Prerequisites

- **Java Development Kit (JDK):** Version 8 or higher installed on your system.

## How to Run

1. Save the source code in a file named `EventTracker.java`.
2. Open your terminal or command prompt and navigate to the folder containing the file.
3. Compile the program:
   ```bash
   javac EventTracker.java
