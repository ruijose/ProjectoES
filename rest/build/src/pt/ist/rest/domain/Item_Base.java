package pt.ist.rest.domain;

import pt.ist.fenixframework.pstm.VBox;
import pt.ist.fenixframework.pstm.RelationList;
import pt.ist.fenixframework.pstm.OJBFunctionalSetWrapper;
import pt.ist.fenixframework.ValueTypeSerializationGenerator.*;
public abstract class Item_Base extends pt.ist.fenixframework.pstm.OneBoxDomainObject {
    public final static pt.ist.fenixframework.pstm.dml.RoleOne<pt.ist.rest.domain.Item,pt.ist.rest.domain.Compra> role$$compra = new pt.ist.fenixframework.pstm.dml.RoleOne<pt.ist.rest.domain.Item,pt.ist.rest.domain.Compra>() {
        public pt.ist.rest.domain.Compra getValue(pt.ist.rest.domain.Item o1) {
            return ((Item_Base.DO_State)o1.get$obj$state(false)).compra;
        }
        public void setValue(pt.ist.rest.domain.Item o1, pt.ist.rest.domain.Compra o2) {
            ((Item_Base.DO_State)o1.get$obj$state(true)).compra = o2;
        }
        public dml.runtime.Role<pt.ist.rest.domain.Compra,pt.ist.rest.domain.Item> getInverseRole() {
            return pt.ist.rest.domain.Compra.role$$item;
        }
        
    };
    public final static pt.ist.fenixframework.pstm.dml.RoleOne<pt.ist.rest.domain.Item,pt.ist.rest.domain.Prato> role$$prato = new pt.ist.fenixframework.pstm.dml.RoleOne<pt.ist.rest.domain.Item,pt.ist.rest.domain.Prato>() {
        public pt.ist.rest.domain.Prato getValue(pt.ist.rest.domain.Item o1) {
            return ((Item_Base.DO_State)o1.get$obj$state(false)).prato;
        }
        public void setValue(pt.ist.rest.domain.Item o1, pt.ist.rest.domain.Prato o2) {
            ((Item_Base.DO_State)o1.get$obj$state(true)).prato = o2;
        }
        public dml.runtime.Role<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Item> getInverseRole() {
            return pt.ist.rest.domain.Prato.role$$item;
        }
        
    };
    public final static pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Item,pt.ist.rest.domain.Compra> CompraContainsItems = new pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Item,pt.ist.rest.domain.Compra>(role$$compra);
    static {
        pt.ist.rest.domain.Compra.CompraContainsItems = CompraContainsItems.getInverseRelation();
    }
    
    static {
        CompraContainsItems.setRelationName("pt.ist.rest.domain.Item.CompraContainsItems");
    }
    public static dml.runtime.Relation<pt.ist.rest.domain.Item,pt.ist.rest.domain.Prato> ItemContainsPratos;
    
    
    
    
    private void initInstance() {
        initInstance(true);
    }
    
    private void initInstance(boolean allocateOnly) {
        
    }
    
    {
        initInstance(false);
    }
    
    protected  Item_Base() {
        super();
    }
    
    public java.lang.Integer getQuantidade() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "quantidade");
        return ((DO_State)this.get$obj$state(false)).quantidade;
    }
    
    public void setQuantidade(java.lang.Integer quantidade) {
        ((DO_State)this.get$obj$state(true)).quantidade = quantidade;
    }
    
    private java.lang.Integer get$quantidade() {
        java.lang.Integer value = ((DO_State)this.get$obj$state(false)).quantidade;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForInteger(value);
    }
    
    private final void set$quantidade(java.lang.Integer arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).quantidade = (java.lang.Integer)((arg0 == null) ? null : arg0);
    }
    
    public pt.ist.rest.domain.Compra getCompra() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "compra");
        return ((DO_State)this.get$obj$state(false)).compra;
    }
    
    public void setCompra(pt.ist.rest.domain.Compra compra) {
        CompraContainsItems.add((pt.ist.rest.domain.Item)this, compra);
    }
    
    public boolean hasCompra() {
        return (getCompra() != null);
    }
    
    public void removeCompra() {
        setCompra(null);
    }
    
    private java.lang.Long get$oidCompra() {
        pt.ist.fenixframework.pstm.AbstractDomainObject value = ((DO_State)this.get$obj$state(false)).compra;
        return (value == null) ? null : value.getOid();
    }
    
    public pt.ist.rest.domain.Prato getPrato() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "prato");
        return ((DO_State)this.get$obj$state(false)).prato;
    }
    
    public void setPrato(pt.ist.rest.domain.Prato prato) {
        ItemContainsPratos.add((pt.ist.rest.domain.Item)this, prato);
    }
    
    public boolean hasPrato() {
        return (getPrato() != null);
    }
    
    public void removePrato() {
        setPrato(null);
    }
    
    private java.lang.Long get$oidPrato() {
        pt.ist.fenixframework.pstm.AbstractDomainObject value = ((DO_State)this.get$obj$state(false)).prato;
        return (value == null) ? null : value.getOid();
    }
    
    protected void checkDisconnected() {
        if (hasCompra()) handleAttemptToDeleteConnectedObject();
        if (hasPrato()) handleAttemptToDeleteConnectedObject();
        
    }
    
    protected void readStateFromResultSet(java.sql.ResultSet rs, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  state) throws java.sql.SQLException {
        DO_State castedState = (DO_State)state;
        set$quantidade(pt.ist.fenixframework.pstm.ResultSetReader.readInteger(rs, "QUANTIDADE"), state);
        castedState.compra = pt.ist.fenixframework.pstm.ResultSetReader.readDomainObject(rs, "OID_COMPRA");
        castedState.prato = pt.ist.fenixframework.pstm.ResultSetReader.readDomainObject(rs, "OID_PRATO");
    }
    protected dml.runtime.Relation get$$relationFor(String attrName) {
        return super.get$$relationFor(attrName);
        
    }
    protected pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  make$newState() {
        return new DO_State();
        
    }
    protected void create$allLists() {
        super.create$allLists();
        
    }
    protected static class DO_State extends pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State {
        private java.lang.Integer quantidade;
        private pt.ist.rest.domain.Compra compra;
        private pt.ist.rest.domain.Prato prato;
        protected void copyTo(pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  newState) {
            super.copyTo(newState);
            DO_State newCasted = (DO_State)newState;
            newCasted.quantidade = this.quantidade;
            newCasted.compra = this.compra;
            newCasted.prato = this.prato;
            
        }
        
        // serialization code
        protected Object writeReplace() throws java.io.ObjectStreamException {
            return new SerializedForm(this);
        }
        
        protected static class SerializedForm extends pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State.SerializedForm {
            private static final long serialVersionUID = 1L;
            
            private java.lang.Integer quantidade;
            private pt.ist.rest.domain.Compra compra;
            private pt.ist.rest.domain.Prato prato;
            
            protected  SerializedForm(DO_State obj) {
                super(obj);
                this.quantidade = obj.quantidade;
                this.compra = obj.compra;
                this.prato = obj.prato;
                
            }
            
             Object readResolve() throws java.io.ObjectStreamException {
                DO_State newState = new DO_State();
                fillInState(newState);
                return newState;
            }
            
            protected void fillInState(pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State obj) {
                super.fillInState(obj);
                DO_State state = (DO_State)obj;
                state.quantidade = this.quantidade;
                state.compra = this.compra;
                state.prato = this.prato;
                
            }
            
        }
        
    }
    
}
