package decorator;

import courses.ICourse;

public class CertificateDecorator extends CourseDecorator {

    public CertificateDecorator(ICourse course) {
        super(course);
    }

    public void grantCertificate() {
        System.out.println("Granting certificate");
    }

    @Override
    public String info() {
        return super.info() + " + Certification";
    }
}
