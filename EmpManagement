import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class EmpManagement extends Application
{
    // Connor Tran - Software Development
    // WILL NOT WORK WITHOUT PROPER SQL DB SETUP
    private static final String DB_URL = "jdbc:mysql://localhost:3306/employeeData"; // Put db link here
    private static final String USER = "connor"; // Put Username here
    private static final String PASS = "tran"; // Put Password here

    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage primaryStage)
    {
        // Dark Mode Main layout with padding and spacing
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #2b2b2b;");

        // Add Employee Section
        Label addLabel = new Label("Add Employee");
        addLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 16px;");
        TextField empNameField = new TextField();
        empNameField.setPromptText("Name");
        TextField empSSNField = new TextField();
        empSSNField.setPromptText("SSN");
        TextField empDivisionField = new TextField();
        empDivisionField.setPromptText("Division");
        TextField empJobTitleField = new TextField();
        empJobTitleField.setPromptText("Job Title");
        TextField empSalaryField = new TextField();
        empSalaryField.setPromptText("Salary");
        Button addEmpButton = new Button("Add Employee");

        // Handle add employee button click
        addEmpButton.setOnAction(e ->
        {
            String name = empNameField.getText();
            String ssn = empSSNField.getText();
            String division = empDivisionField.getText();
            String jobTitle = empJobTitleField.getText();
            try
            {
                float salary = Float.parseFloat(empSalaryField.getText());
                addEmployee(name, ssn, division, jobTitle, salary);
            }
            catch (NumberFormatException ex)
            {
                showError("Invalid Salary", "Please enter a valid salary.");
            }
        });

        // Search Employee Section
        Separator separator1 = new Separator();
        separator1.setStyle("-fx-background-color: #000000; -fx-pref-width: 300px;");
        Label searchLabel = new Label("Search Employee");
        searchLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 16px;");
        TextField searchField = new TextField();
        searchField.setPromptText("Enter Name, SSN, or ID");
        Button searchButton = new Button("Search");

        // Handle search employee button click
        searchButton.setOnAction(e ->
        {
            String identifier = searchField.getText();
            if (identifier.trim().isEmpty())
            {
                showError("Invalid Input", "Please enter a name, SSN, or ID.");
            }
            else
            {
                searchEmployee(identifier);
            }
        });

        // Update Salary Section
        Separator separator2 = new Separator();
        separator2.setStyle("-fx-background-color: #000000; -fx-pref-width: 300px;");
        Label updateLabel = new Label("Update Salary");
        updateLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 16px;");
        TextField minSalaryField = new TextField();
        minSalaryField.setPromptText("Min Salary");
        TextField maxSalaryField = new TextField();
        maxSalaryField.setPromptText("Max Salary");
        TextField percentageField = new TextField();
        percentageField.setPromptText("Percentage Increase");
        Button updateSalaryButton = new Button("Update Salary");

        // Handle update salary button click
        updateSalaryButton.setOnAction(e ->
        {
            try
            {
                float minSalary = Float.parseFloat(minSalaryField.getText());
                float maxSalary = Float.parseFloat(maxSalaryField.getText());
                float percentage = Float.parseFloat(percentageField.getText());
                updateSalary(minSalary, maxSalary, percentage);
            }
            catch (NumberFormatException ex)
            {
                showError("Invalid Input", "Please enter valid numbers.");
            }
        });

        // Generate Report section
        Separator separator3 = new Separator();
        separator3.setStyle("-fx-background-color: #000000; -fx-pref-width: 300px;");
        Label reportLabel = new Label("Generate Reports");
        reportLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 16px;");

        ComboBox<String> reportOptions = new ComboBox<>();
        reportOptions.setItems(FXCollections.observableArrayList(
                "Full-Time Employee Pay Statements",
                "Total Pay by Job Title",
                "Total Pay by Division"
        ));
        reportOptions.setPromptText("Select Report Type");

        Button generateReportButton = new Button("Generate Report");

        // Handle report generation button click
        generateReportButton.setOnAction(e ->
        {
            String selectedReport = reportOptions.getValue();
            if (selectedReport == null)
            {
                showError("No Report Selected", "Please select a report type.");
            }
            else
            {
                generateReportToFile(selectedReport);
            }
        });

        // Layout the UI components
        layout.getChildren().addAll
                (
                        addLabel, empNameField, empSSNField, empDivisionField, empJobTitleField, empSalaryField, addEmpButton,
                        separator1, searchLabel, searchField, searchButton,
                        separator2, updateLabel, minSalaryField, maxSalaryField, percentageField, updateSalaryButton,
                        separator3, reportLabel, reportOptions, generateReportButton
                );

        // Scene
        Scene scene = new Scene(layout, 700, 810);
        primaryStage.setTitle("Employee Management System - Dark Mode");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // ----------------------------------------------------------------------------------------------------------- \\
    // ----------------------------------------------------------------------------------------------------------- \\

    // Method to add an employee to the database
    private void addEmployee(String name, String ssn, String division, String jobTitle, float salary)
    {
        String query = "INSERT INTO employee (name, ssn, division, job_title, salary) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(query))
        {
            stmt.setString(1, name);
            stmt.setString(2, ssn);
            stmt.setString(3, division);
            stmt.setString(4, jobTitle);
            stmt.setFloat(5, salary);
            stmt.executeUpdate();
            showInfo("Success", "Employee added successfully!");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            showError("Database Error", "An error occurred while adding the employee.");
        }
    }

    // Method to search for an employee in the database
    private void searchEmployee(String identifier)
    {
        String query = "SELECT * FROM employee WHERE name = ? OR ssn = ? OR employeeID = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(query))
        {
            stmt.setString(1, identifier);
            stmt.setString(2, identifier);
            stmt.setString(3, identifier);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                System.out.println("Employee Found: " +
                        "Name: " + rs.getString("name") +
                        ", Division: " + rs.getString("division") +
                        ", Job Title: " + rs.getString("job_title") +
                        ", Salary: " + rs.getFloat("salary"));
            }
            else
            {
                showError("Employee Not Found", "No employee found with that identifier.");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            showError("Database Error", "An error occurred while searching for the employee.");
        }
    }

    // Method to update salaries of employees based on the range
    private void updateSalary(float minSalary, float maxSalary, float percentageIncrease)
    {
        String query = "UPDATE employee SET salary = salary * (1 + ?) WHERE salary >= ? AND salary < ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(query))
        {
            stmt.setFloat(1, percentageIncrease / 100);
            stmt.setFloat(2, minSalary);
            stmt.setFloat(3, maxSalary);
            int rowsUpdated = stmt.executeUpdate();
            showInfo("Success", rowsUpdated + " employees had their salaries updated.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            showError("Database Error", "An error occurred while updating salaries.");
        }
    }

    // Method to generate reports
    private void generateReportToFile(String reportType)
    {
        String query = null;
        String fileName = null;

        switch (reportType)
        {
            case "Full-Time Employee Pay Statements":
                query = "SELECT * FROM employee"; // Customize based on your database schema
                fileName = "FullTimeEmployeePayStatements.txt";
                break;
            case "Total Pay by Job Title":
                query = "SELECT job_title, SUM(salary) as total_pay FROM employee GROUP BY job_title";
                fileName = "TotalPayByJobTitle.txt";
                break;
            case "Total Pay by Division":
                query = "SELECT division, SUM(salary) as total_pay FROM employee GROUP BY division";
                fileName = "TotalPayByDivision.txt";
                break;
            default:
                showError("Invalid Report Type", "The selected report type is not supported.");
                return; // Exit early for invalid options
        }
        StringBuilder reportContent = new StringBuilder();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery())
        {
            // Create report content based on the result set
            if (reportType.equals("Full-Time Employee Pay Statements"))
            {
                while (rs.next())
                {
                    reportContent.append(String.format("ID: %d | Name: %s | Division: %s | Job Title: %s | Salary: %.2f%n",
                            rs.getInt("employeeID"), rs.getString("name"),
                            rs.getString("division"), rs.getString("job_title"), rs.getFloat("salary")));
                }
            }
            else
            {
                while (rs.next())
                {
                    String groupBy = reportType.equals("Total Pay by Job Title") ? "job_title" : "division";
                    reportContent.append(String.format("%s: %s | Total Pay: %.2f%n",
                            groupBy, rs.getString(groupBy), rs.getFloat("total_pay")));
                }
            }

            // Save to file
            if (!reportContent.isEmpty()) {
                saveReportToFile(reportContent.toString(), fileName);
                showInfo("Report Generated", "Report saved as: " + fileName);
            }
            else
            {
                showError("No Data", "The selected report has no data.");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            showError("Database Error", "An error occurred while generating the report.");
        }
    }


    // Helper method to save the report to a text file
    private void saveReportToFile(String reportContent, String fileName)
    {
        try
        {
            java.nio.file.Path path = java.nio.file.Paths.get(fileName);
            java.nio.file.Files.write(path, reportContent.getBytes());
        }
        catch (java.io.IOException e)
        {
            e.printStackTrace();
            showError("File Error", "An error occurred while saving the report.");
        }
    }

    // Helper method to show error dialog
    private void showError(String title, String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Helper method to show success info
    private void showInfo(String title, String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
