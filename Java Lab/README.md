# Java GUI Lab Assignments & Experiments

This repository contains Java Swing GUI implementations for all the assignments and experiments specified in `labasn.pdf`.

---

## Index of Files & Descriptions

| # | File Name | Assignment / Experiment Title | Key Components Used |
|---|-----------|-------------------------------|---------------------|
| 1 | [`ColorIdentifier.java`](file:///c:/Users/Pushkar%20Raj/Desktop/Practice-Codes/Java-Learning/Java%20Lab/ColorIdentifier.java) | **Color Identifier for Kids** | `JFrame`, `JButton`, `JLabel`, `JPanel` |
| 2 | [`SimpleCalculator.java`](file:///c:/Users/Pushkar%20Raj/Desktop/Practice-Codes/Java-Learning/Java%20Lab/SimpleCalculator.java) | **Simple Arithmetic Calculator** | `JFrame`, `JLabel`, `JTextField`, `JButton` |
| 3 | [`SmallestFactorial.java`](file:///c:/Users/Pushkar%20Raj/Desktop/Practice-Codes/Java-Learning/Java%20Lab/SmallestFactorial.java) | **Factorial of Smallest Among 3 Numbers** | `JFrame`, `JLabel`, `JTextField`, `JButton`, `BigInteger` |
| 4 | [`NumberInfo.java`](file:///c:/Users/Pushkar%20Raj/Desktop/Practice-Codes/Java-Learning/Java%20Lab/NumberInfo.java) | **Number Properties Analyzer** | `JFrame`, `JLabel`, `JTextField`, `JButton` |
| 5 | [`StudentGradeManagement.java`](file:///c:/Users/Pushkar%20Raj/Desktop/Practice-Codes/Java-Learning/Java%20Lab/StudentGradeManagement.java) | **Experiment 1: Student Marks & Grade Management** | `JFrame`, `JTextField`, `JButton`, `JTextArea`, `JOptionPane` |
| 6 | [`BankingSystem.java`](file:///c:/Users/Pushkar%20Raj/Desktop/Practice-Codes/Java-Learning/Java%20Lab/BankingSystem.java) | **Experiment 2: Basic Banking & Transaction System** | `JFrame`, `JTextField`, `JButton`, `JLabel`, `JTextArea` |
| 7 | [`OnlineExamSystem.java`](file:///c:/Users/Pushkar%20Raj/Desktop/Practice-Codes/Java-Learning/Java%20Lab/OnlineExamSystem.java) | **Experiment 3: Online Examination & Quiz System** | `JFrame`, `JLabel`, `JRadioButton`, `ButtonGroup`, `JButton`, `JOptionPane` |

---

## Detailed Overview of Each Program

### 1. `ColorIdentifier.java`
- **Objective:** Helps kids identify 5 colors: **Red**, **Blue**, **Green**, **Orange**, and **Yellow** using `JButton`.
- **Features:**
  - Dynamic interactive color card that updates background and friendly descriptions.
  - Reset button to restore default state.

### 2. `SimpleCalculator.java`
- **Objective:** Performs all basic arithmetic operations (`+`, `-`, `×`, `÷`, `%`) on two numbers.
- **Features:**
  - Robust error handling for `NumberFormatException` (non-numeric values).
  - Validation for division and modulus by zero.
  - Clear/Reset button.

### 3. `SmallestFactorial.java`
- **Objective:** Accepts 3 numbers, determines the smallest among them, and calculates its factorial.
- **Features:**
  - Computes the minimum value using `Math.min()`.
  - Uses `BigInteger` to accurately handle large factorials without numeric overflow.
  - Checks for negative numbers where factorial is undefined.

### 4. `NumberInfo.java`
- **Objective:** Analyzes a given integer and provides detailed mathematical properties:
  - **Sign:** Positive, Negative, or Zero.
  - **Parity:** Even or Odd.
  - **Primality:** Prime or Composite (or neither for numbers $\le 1$).
  - **Palindrome:** Palindrome or Not Palindrome.

### 5. `StudentGradeManagement.java` (Experiment 1)
- **Objective:** Complete automated student academic performance calculation system.
- **Features:**
  - Accepts Student Roll Number, Name, and Department.
  - 5 subject mark entry fields with strict score range validation ($0 \le \text{marks} \le 100$).
  - Calculates Total Marks (out of 500) and Percentage.
  - Determines academic letter grade (`A+`, `A`, `B`, `C`, `D`, `E`, `F`) and Pass/Fail status.
  - Formatted report card generated inside a scrollable `JTextArea`.
  - Reset button to clear all inputs.

### 6. `BankingSystem.java` (Experiment 2)
- **Objective:** Desktop banking application demonstrating deposit, withdrawal, balance enquiry, and event handling.
- **Features:**
  - Displays Account Number and Account Holder Name.
  - Real-time balance display.
  - Deposit: Adds valid positive amount to balance.
  - Withdraw: Verifies sufficient balance before deducting; shows clear error message if balance is insufficient.
  - Check Balance dialog.
  - Live Passbook / Transaction audit history log with timestamps.
  - Reset transaction button.

### 7. `OnlineExamSystem.java` (Experiment 3)
- **Objective:** Interactive computer-based objective examination / quiz system.
- **Features:**
  - Header with Exam Title and Student Candidate details.
  - Question rendering using `JLabel`.
  - 4 multiple-choice options using `JRadioButton` grouped with `ButtonGroup`.
  - Previous (`◀`) and Next (`▶`) navigation preserving student selections across questions.
  - Submit Examination button with a confirmation dialog (`JOptionPane.showConfirmDialog`).
  - Final score report displaying Total Questions, Attempted, Correct, Incorrect, and Final Score.

---

## How to Compile & Run

Open a terminal (Command Prompt or PowerShell) inside this directory (`Java Lab`) and run:

```bash
# Compile any file:
javac <FileName>.java

# Run the compiled program:
java <FileName>
```

### Examples:
```bash
# 1. Color Identifier:
javac ColorIdentifier.java
java ColorIdentifier

# 2. Simple Calculator:
javac SimpleCalculator.java
java SimpleCalculator

# 3. Factorial of Smallest:
javac SmallestFactorial.java
java SmallestFactorial

# 4. Number Information:
javac NumberInfo.java
java NumberInfo

# 5. Experiment 1: Student Grade Management:
javac StudentGradeManagement.java
java StudentGradeManagement

# 6. Experiment 2: Banking System:
javac BankingSystem.java
java BankingSystem

# 7. Experiment 3: Online Exam System:
javac OnlineExamSystem.java
java OnlineExamSystem
```
