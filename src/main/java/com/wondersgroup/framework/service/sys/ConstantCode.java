package com.wondersgroup.framework.service.sys;

/**
 * 
 * 系统常量对应标示--代码注册
 * 
 * @author zpfox
 */
public interface ConstantCode
{
    /**
     * 审核角色代码
     */
    public static final String AUDIT_ROLE = "Competent";
    
    /**
     * 销售角色代码
     */
    public static final String SALES_ROLE = "Sell";
    /**
     * 商务角色代码
     */
    public static final String BUSINESS_ROLE = "Business";
    
    /* -----------项目流程操作代码--------- */
    /**
     *  管理操作标志--采购
     */
    public static final String DEVICE_PURCHASE = "devicePurchase";
    
    /**
     *  管理操作标志--收货
     */
    public static final String DEVICE_RECEIVING = "deviceReceiving";
    
    /**
     *  管理操作标志--发货
     */
    public static final String DEVICE_DELIVERY = "deviceDelivery";
    
    /**
     *  管理操作标志--客户确认
     */
    public static final String CUSTOMER_CONFIRM = "customerConfirm";
    
    /**
     *  管理操作标志--设备售后
     */
    public static final String DEVICE_AFTER_SALES_SERVICE = "afterService";
    
    /*------合同操作常量----------*/
    /**
     *  管理操作标志--保存
     */
    public static final String OPER_SAVE = "Save";
    
    /**
     *  管理操作标志--驳回
     */
    public static final String OPER_REJECT = "Reject";
    
    /**
     *  管理操作标志--销售合同审核
     */
    public static final String OPER_AUDIT = "Audit";
    
    /**
    *  管理操作标志--采购合同审核
    */
    public static final String OPER_PO_AUDIT = "PO_Audit";
    
    /**
     *  管理操作标志--提交
     */
    public static final String OPER_SUBMIT = "Submit";
    
    /* -----------合同流程状态代码需要与系统常量表中的一致---------- */
    /**
     *  合同"已保存"状态代码
     */
    public static final String CONTRACT_SOSAVE = "SoSave";
    
    /**
     * 合同--"已提交"状态代码
     */
    public static final String CONTRACT_SUBMIT = "SoSubmit";
    
    /**
     *  合同"已审核"状态代码
     */
    public static final String CONTRACT_SOAUDIT = "SoAudit";
    
    /* -----------设备流程状态代码需要与系统常量表中的一致---------- */
    /**
     * 设备待采购状态代码
     */
    public static final String DEVICE_WAIT_PURCHASE = "Wait_Purchase";
    
    /**
     * 设备待收货状态代码
     */
    public static final String DEVICE_WAIT_RECEIVING = "Wait_Receiving";
    
    /**
     * 设备待发货状态代码
     */
    public static final String DEVICE_WAIT_SHIPMENTS = "Wait_Shipments";
    
    /**
     * 设备待确认状态代码
     */
    public static final String DEVICE_WAIT_CONFIRM = "Wait_Confirm";
    
    /**
     * 设备售后状态代码
     */
    public static final String DEVICE_AFTERMARKET = "Aftermarket";
    
}
