# Task 3: ATM Interface (Java)

A console-based ATM simulation application engineered in Java. This project implements clean Object-Oriented Programming (OOP) design patterns to separate business logic, data storage, and user interface controls.

---

## 🏗️ Architecture & OOP Design

The system decouples responsibilities across **5 distinct Java classes** to enforce strict encapsulation:

* **`Main`** — The initialization layer; instantiates the data structures and starts the system runtime execution thread.
* **`ATM`** — The Presentation Layer; handles user inputs, outputs, menu displays, and session interaction loops.
* **`Bank`** — The Data Access Layer; acts as an in-memory repository managing all valid consumer accounts.
* **`Account`** — The Business Logic Layer; capsulates user metrics, operational balances, and handles direct ledger balances.
* **`Transaction`** — The Data Model; standardizes individual session history logs (Deposits, Withdrawals, Transfers).

---

## 🛠️ Feature Checklist

- [x] **Secure Authentication System** — Verification required for User ID and password/PIN profiles.
- [x] **Account Lockout Guardrail** — Enforces termination of interface access after 3 consecutive invalid authentication attempts.
- [x] **Dynamic Session Logging** — Monitors and aggregates account movements sequentially within a generic `ArrayList`.
- [x] **Real-Time Financial Logic** — Pre-validates account liquidity limits before processing debits to block account overdrafts.
- [x] **Inter-Account Transfers** — Programmatically links and executes transactional balance routing across verified client records.

---

## 💾 Pre-Loaded Test Accounts

Use the following parameters to authenticate and validate system state transformations:

| User ID | PIN | Initial Balance |
| :--- | :--- | :--- |
| `user123` | `1111` | $1000.00 |
| `user456` | `2222` | $500.00 |

---

## 🚀 Execution Instructions

### Option A: Via VS Code (Recommended)
1. Launch **VS Code** and select **File > Open Folder** targeting the `Java-Task3-ATMInterface` root.
2. Ensure the **Extension Pack for Java** (Microsoft) is enabled.
3. Open `Main.java` and click the **Run** text or the **Play Triangle** in the upper-right control dock.

### Option B: Via Terminal / Native CLI
Navigate inside the repository container folder and invoke standard compilation chains:
```bash
# Compile structural resources
javac *.java

# Instantiate runtime environment
java Main
