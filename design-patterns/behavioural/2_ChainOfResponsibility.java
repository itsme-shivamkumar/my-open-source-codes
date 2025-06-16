public abstract class Handler{
    private Handler nextHanlder;
    
    public Handler setNextHandler(Handler handler){
        this.nextHanlder = handler;
        return this.nextHanlder;
    }

    public abstract boolean handle(Map<Object, Object> details);

    protected boolean handleNext(Map<Object, Object> details){
        if(Objects.isNull(nextHanlder)){
            return true;
        }
        return nextHanlder.handle(details);
    }
}



/**
 * 🏦 Problem Statement: Multi-Step Transaction Validation Pipeline
 * Your fintech platform processes millions of card transactions daily. To ensure safety, compliance, and quality, each transaction 
 *   must go through a validation pipeline before approval.
 * 
 * The validation logic must support:
 * 🔍 Basic checks (e.g., amount > 0, non-null card)
 * 🧑‍⚖️ Compliance validation (e.g., check if the user is KYC verified)
 * 🚨 Fraud risk assessment (e.g., limit checks, velocity rules)
 * 🧮 Balance check (ensure sufficient funds)
 * 🔒 Security check (e.g., card not blocked, PIN verified)
 * 
 * Each of these validations should be modular:
 * Each step should decide whether to pass the transaction to the next validator or reject it immediately.
 * New validation rules might be added in the future without changing the existing ones.
 * Validation logic should not be hardcoded in a monolithic if-else or switch block.
 * Your goal is to design a flexible, extensible transaction validation system that supports this pipeline.
 * 
 * Optional Business Features:
 * Logging the validator that rejected the transaction.
 * Allowing some validators to operate only in certain modes (e.g., fraud checks only for high-risk users).
 * Skipping validations dynamically based on card type, transaction source, or environment (e.g., sandbox).

 */