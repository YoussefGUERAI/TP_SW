public interface PaymentProcessor {
    void payByCreditCard ( double amount ) ;
    void payByPayPal ( double amount ) ;
    void refund ( double amount ) ;
 }

class QuickPay {
    public void creditCardPayment(double amount) {
        System.out.println("QuickPay : Processing credit card payment of: " + amount);
    } 
    public void payPalPayment(double amount) {
        System.out.println("QuickPay : Processing PayPal payment of: " + amount);
    }  
    public void reversetransaction(double amount) {
        System.out.println("QuickPay : Refunding amount of: " + amount);
    }   
 }

class SafeTransfer {
    public void payWithCard(double amount) {
        System.out.println("SafeTransfer : Paying with card: " + amount);
    }
    public void payViaPayPal(double amount) {
        System.out.println("SafeTransfer : Paying via PayPal: " + amount);
    }
    public void refundPayment(double amount) {
        System.out.println("SafeTransfer : Issuing refund of: " + amount);
    }
}

class QuickPayAdapter implements PaymentProcessor {
    private QuickPay quickPay;

    public QuickPayAdapter(QuickPay quickPay) {
        this.quickPay = quickPay;
    }

    public void payByCreditCard(double amount) {
        quickPay.creditCardPayment(amount);
    }

    public void payByPayPal(double amount) {
        quickPay.payPalPayment(amount);
    }

    public void refund(double amount) {
        quickPay.reversetransaction(amount);
    }
}

class SafeTransferAdapter implements PaymentProcessor {
    private SafeTransfer safeTransfer;

    public SafeTransferAdapter(SafeTransfer safeTransfer) {
        this.safeTransfer = safeTransfer;
    }

    public void payByCreditCard(double amount) {
        safeTransfer.payWithCard(amount);
    }

    public void payByPayPal(double amount) {
        safeTransfer.payViaPayPal(amount);
    }

    public void refund(double amount) {
        safeTransfer.refundPayment(amount);
    }
}

class Main{
    public static void main(String[] args) {
        PaymentProcessor quickPayProcessor = new QuickPayAdapter(new QuickPay());
        PaymentProcessor safeTransferProcessor = new SafeTransferAdapter(new SafeTransfer());

        quickPayProcessor.payByCreditCard(100.0);
        quickPayProcessor.payByPayPal(50.0);
        quickPayProcessor.refund(20.0);

        safeTransferProcessor.payByCreditCard(200.0);
        safeTransferProcessor.payByPayPal(80.0);
        safeTransferProcessor.refund(30.0);
    }
}