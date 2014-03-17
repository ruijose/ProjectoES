package pt.ist.rest.domain;

import pt.ist.fenixframework.pstm.VBox;
import pt.ist.fenixframework.pstm.RelationList;
import pt.ist.fenixframework.pstm.OJBFunctionalSetWrapper;
import pt.ist.fenixframework.ValueTypeSerializationGenerator.*;
public abstract class Compra_Base extends pt.ist.fenixframework.pstm.OneBoxDomainObject {
    public final static dml.runtime.RoleMany<pt.ist.rest.domain.Compra,pt.ist.rest.domain.Item> role$$item = new dml.runtime.RoleMany<pt.ist.rest.domain.Compra,pt.ist.rest.domain.Item>() {
        public dml.runtime.RelationBaseSet<pt.ist.rest.domain.Item> getSet(pt.ist.rest.domain.Compra o1) {
            return ((Compra_Base)o1).get$rl$item();
        }
        public dml.runtime.Role<pt.ist.rest.domain.Item,pt.ist.rest.domain.Compra> getInverseRole() {
            return pt.ist.rest.domain.Item.role$$compra;
        }
        
    };
    public final static pt.ist.fenixframework.pstm.dml.RoleOne<pt.ist.rest.domain.Compra,pt.ist.rest.domain.Cliente> role$$cliente = new pt.ist.fenixframework.pstm.dml.RoleOne<pt.ist.rest.domain.Compra,pt.ist.rest.domain.Cliente>() {
        public pt.ist.rest.domain.Cliente getValue(pt.ist.rest.domain.Compra o1) {
            return ((Compra_Base.DO_State)o1.get$obj$state(false)).cliente;
        }
        public void setValue(pt.ist.rest.domain.Compra o1, pt.ist.rest.domain.Cliente o2) {
            ((Compra_Base.DO_State)o1.get$obj$state(true)).cliente = o2;
        }
        public dml.runtime.Role<pt.ist.rest.domain.Cliente,pt.ist.rest.domain.Compra> getInverseRole() {
            return pt.ist.rest.domain.Cliente.role$$compra;
        }
        
    };
    public static dml.runtime.Relation<pt.ist.rest.domain.Compra,pt.ist.rest.domain.Item> CompraContainsItems;
    public final static pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Compra,pt.ist.rest.domain.Cliente> ClienteContainsCompras = new pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Compra,pt.ist.rest.domain.Cliente>(role$$cliente);
    static {
        pt.ist.rest.domain.Cliente.ClienteContainsCompras = ClienteContainsCompras.getInverseRelation();
    }
    
    static {
        ClienteContainsCompras.setRelationName("pt.ist.rest.domain.Compra.ClienteContainsCompras");
    }
    
    
    private RelationList<pt.ist.rest.domain.Compra,pt.ist.rest.domain.Item> get$rl$item() {
        return get$$relationList("item", CompraContainsItems);
        
    }
    
    
    private void initInstance() {
        initInstance(true);
    }
    
    private void initInstance(boolean allocateOnly) {
        
    }
    
    {
        initInstance(false);
    }
    
    protected  Compra_Base() {
        super();
    }
    
    public java.lang.Integer getCusto() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "custo");
        return ((DO_State)this.get$obj$state(false)).custo;
    }
    
    public void setCusto(java.lang.Integer custo) {
        ((DO_State)this.get$obj$state(true)).custo = custo;
    }
    
    private java.lang.Integer get$custo() {
        java.lang.Integer value = ((DO_State)this.get$obj$state(false)).custo;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForInteger(value);
    }
    
    private final void set$custo(java.lang.Integer arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).custo = (java.lang.Integer)((arg0 == null) ? null : arg0);
    }
    
    public java.lang.Integer getConfirma() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "confirma");
        return ((DO_State)this.get$obj$state(false)).confirma;
    }
    
    public void setConfirma(java.lang.Integer confirma) {
        ((DO_State)this.get$obj$state(true)).confirma = confirma;
    }
    
    private java.lang.Integer get$confirma() {
        java.lang.Integer value = ((DO_State)this.get$obj$state(false)).confirma;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForInteger(value);
    }
    
    private final void set$confirma(java.lang.Integer arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).confirma = (java.lang.Integer)((arg0 == null) ? null : arg0);
    }
    
    public int getItemCount() {
        return get$rl$item().size();
    }
    
    public boolean hasAnyItem() {
        return (! get$rl$item().isEmpty());
    }
    
    public boolean hasItem(pt.ist.rest.domain.Item item) {
        return get$rl$item().contains(item);
    }
    
    public java.util.Set<pt.ist.rest.domain.Item> getItemSet() {
        return get$rl$item();
    }
    
    public void addItem(pt.ist.rest.domain.Item item) {
        CompraContainsItems.add((pt.ist.rest.domain.Compra)this, item);
    }
    
    public void removeItem(pt.ist.rest.domain.Item item) {
        CompraContainsItems.remove((pt.ist.rest.domain.Compra)this, item);
    }
    
    public java.util.List<pt.ist.rest.domain.Item> getItem() {
        return get$rl$item();
    }
    
    public void set$item(OJBFunctionalSetWrapper item) {
        get$rl$item().setFromOJB(this, "item", item);
    }
    
    public java.util.Iterator<pt.ist.rest.domain.Item> getItemIterator() {
        return get$rl$item().iterator();
    }
    
    public pt.ist.rest.domain.Cliente getCliente() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "cliente");
        return ((DO_State)this.get$obj$state(false)).cliente;
    }
    
    public void setCliente(pt.ist.rest.domain.Cliente cliente) {
        ClienteContainsCompras.add((pt.ist.rest.domain.Compra)this, cliente);
    }
    
    public boolean hasCliente() {
        return (getCliente() != null);
    }
    
    public void removeCliente() {
        setCliente(null);
    }
    
    private java.lang.Long get$oidCliente() {
        pt.ist.fenixframework.pstm.AbstractDomainObject value = ((DO_State)this.get$obj$state(false)).cliente;
        return (value == null) ? null : value.getOid();
    }
    
    protected void checkDisconnected() {
        if (hasAnyItem()) handleAttemptToDeleteConnectedObject();
        if (hasCliente()) handleAttemptToDeleteConnectedObject();
        
    }
    
    protected void readStateFromResultSet(java.sql.ResultSet rs, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  state) throws java.sql.SQLException {
        DO_State castedState = (DO_State)state;
        set$custo(pt.ist.fenixframework.pstm.ResultSetReader.readInteger(rs, "CUSTO"), state);
        set$confirma(pt.ist.fenixframework.pstm.ResultSetReader.readInteger(rs, "CONFIRMA"), state);
        castedState.cliente = pt.ist.fenixframework.pstm.ResultSetReader.readDomainObject(rs, "OID_CLIENTE");
    }
    protected dml.runtime.Relation get$$relationFor(String attrName) {
        if (attrName.equals("item")) return CompraContainsItems;
        return super.get$$relationFor(attrName);
        
    }
    protected pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  make$newState() {
        return new DO_State();
        
    }
    protected void create$allLists() {
        super.create$allLists();
        get$$relationList("item", CompraContainsItems);
        
    }
    protected static class DO_State extends pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State {
        private java.lang.Integer custo;
        private java.lang.Integer confirma;
        private pt.ist.rest.domain.Cliente cliente;
        protected void copyTo(pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  newState) {
            super.copyTo(newState);
            DO_State newCasted = (DO_State)newState;
            newCasted.custo = this.custo;
            newCasted.confirma = this.confirma;
            newCasted.cliente = this.cliente;
            
        }
        
        // serialization code
        protected Object writeReplace() throws java.io.ObjectStreamException {
            return new SerializedForm(this);
        }
        
        protected static class SerializedForm extends pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State.SerializedForm {
            private static final long serialVersionUID = 1L;
            
            private java.lang.Integer custo;
            private java.lang.Integer confirma;
            private pt.ist.rest.domain.Cliente cliente;
            
            protected  SerializedForm(DO_State obj) {
                super(obj);
                this.custo = obj.custo;
                this.confirma = obj.confirma;
                this.cliente = obj.cliente;
                
            }
            
             Object readResolve() throws java.io.ObjectStreamException {
                DO_State newState = new DO_State();
                fillInState(newState);
                return newState;
            }
            
            protected void fillInState(pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State obj) {
                super.fillInState(obj);
                DO_State state = (DO_State)obj;
                state.custo = this.custo;
                state.confirma = this.confirma;
                state.cliente = this.cliente;
                
            }
            
        }
        
    }
    
}
