
class StudentController {

    Student model;
    StudentView view;

    StudentController(Student model, StudentView view) {

        this.model = model;
        this.view = view;
    }

    void updateView() {

        view.display(model.getName());
    }
}