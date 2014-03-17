package pt.ist.rest.domain;

import pt.ist.fenixframework.pstm.VBox;
import pt.ist.fenixframework.pstm.RelationList;
import pt.ist.fenixframework.pstm.OJBFunctionalSetWrapper;
import pt.ist.fenixframework.ValueTypeSerializationGenerator.*;
public abstract class Cliente_Base extends pt.ist.rest.domain.Utilizador {
    public final static dml.runtime.RoleMany<pt.ist.rest.domain.Cliente,pt.ist.rest.domain.Prato> role$$prato = new dml.runtime.RoleMany<pt.ist.rest.domain.Cliente,pt.ist.rest.domain.Prato>() {
        public dml.runtime.RelationBaseSet<pt.ist.rest.domain.Prato> getSet(pt.ist.rest.domain.Cliente o1) {
            return ((Cliente_Base)o1).get$rl$prato();
        }
        public dml.runtime.Role<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Cliente> getInverseRole() {
            return pt.ist.rest.domain.Prato.role$$cliente;
        }
        
    };
    public final static pt.ist.fenixframework.pstm.dml.RoleOne<pt.ist.rest.domain.Cliente,pt.ist.rest.domain.Rest> role$$rest = new pt.ist.fenixframework.pstm.dml.RoleOne<pt.ist.rest.domain.Cliente,pt.ist.rest.domain.Rest>() {
        public pt.ist.rest.domain.Rest getValue(pt.ist.rest.domain.Cliente o1) {
            return ((Cliente_Base.DO_State)o1.get$obj$state(false)).rest;
        }
        public void setValue(pt.ist.rest.domain.Cliente o1, pt.ist.rest.domain.Rest o2) {
            ((Cliente_Base.DO_State)o1.get$obj$state(true)).rest = o2;
        }
        public dml.runtime.Role<pt.ist.rest.domain.Rest,pt.ist.rest.domain.Cliente> getInverseRole() {
            return pt.ist.rest.domain.Rest.role$$cliente;
        }
        
    };
    public final static dml.runtime.RoleMany<pt.ist.rest.domain.Cliente,pt.ist.rest.domain.Compra> role$$compra = new dml.runtime.RoleMany<pt.ist.rest.domain.Cliente,pt.ist.rest.domain.Compra>() {
        public dml.runtime.RelationBaseSet<pt.ist.rest.domain.Compra> getSet(pt.ist.rest.domain.Cliente o1) {
            return ((Cliente_Base)o1).get$rl$compra();
        }
        public dml.runtime.Role<pt.ist.rest.domain.Compra,pt.ist.rest.domain.Cliente> getInverseRole() {
            return pt.ist.rest.domain.Compra.role$$cliente;
        }
        
    };
    public static dml.runtime.Relation<pt.ist.rest.domain.Cliente,pt.ist.rest.domain.Prato> ClienteContainsPratos;
    public final static pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Cliente,pt.ist.rest.domain.Rest> RestContainsClientes = new pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Cliente,pt.ist.rest.domain.Rest>(role$$rest);
    static {
        pt.ist.rest.domain.Rest.RestContainsClientes = RestContainsClientes.getInverseRelation();
    }
    
    static {
        RestContainsClientes.setRelationName("pt.ist.rest.domain.Cliente.RestContainsClientes");
    }
    public static dml.runtime.Relation<pt.ist.rest.domain.Cliente,pt.ist.rest.domain.Compra> ClienteContainsCompras;
    
    
    private RelationList<pt.ist.rest.domain.Cliente,pt.ist.rest.domain.Prato> get$rl$prato() {
        return get$$relationList("prato", ClienteContainsPratos);
        
    }
    private RelationList<pt.ist.rest.domain.Cliente,pt.ist.rest.domain.Compra> get$rl$compra() {
        return get$$relationList("compra", ClienteContainsCompras);
        
    }
    
    
    private void initInstance() {
        initInstance(true);
    }
    
    private void initInstance(boolean allocateOnly) {
        
    }
    
    {
        initInstance(false);
    }
    
    protected  Cliente_Base() {
        super();
    }
    
    public java.lang.String getNome() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "nome");
        return ((DO_State)this.get$obj$state(false)).nome;
    }
    
    public void setNome(java.lang.String nome) {
        ((DO_State)this.get$obj$state(true)).nome = nome;
    }
    
    private java.lang.String get$nome() {
        java.lang.String value = ((DO_State)this.get$obj$state(false)).nome;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForString(value);
    }
    
    private final void set$nome(java.lang.String arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).nome = (java.lang.String)((arg0 == null) ? null : arg0);
    }
    
    public java.lang.String getMorada() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "morada");
        return ((DO_State)this.get$obj$state(false)).morada;
    }
    
    public void setMorada(java.lang.String morada) {
        ((DO_State)this.get$obj$state(true)).morada = morada;
    }
    
    private java.lang.String get$morada() {
        java.lang.String value = ((DO_State)this.get$obj$state(false)).morada;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForString(value);
    }
    
    private final void set$morada(java.lang.String arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).morada = (java.lang.String)((arg0 == null) ? null : arg0);
    }
    
    public java.lang.String getEmail() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "email");
        return ((DO_State)this.get$obj$state(false)).email;
    }
    
    public void setEmail(java.lang.String email) {
        ((DO_State)this.get$obj$state(true)).email = email;
    }
    
    private java.lang.String get$email() {
        java.lang.String value = ((DO_State)this.get$obj$state(false)).email;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForString(value);
    }
    
    private final void set$email(java.lang.String arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).email = (java.lang.String)((arg0 == null) ? null : arg0);
    }
    
    public java.lang.Integer getNif() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "nif");
        return ((DO_State)this.get$obj$state(false)).nif;
    }
    
    public void setNif(java.lang.Integer nif) {
        ((DO_State)this.get$obj$state(true)).nif = nif;
    }
    
    private java.lang.Integer get$nif() {
        java.lang.Integer value = ((DO_State)this.get$obj$state(false)).nif;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForInteger(value);
    }
    
    private final void set$nif(java.lang.Integer arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).nif = (java.lang.Integer)((arg0 == null) ? null : arg0);
    }
    
    public java.lang.Integer getSaldo() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "saldo");
        return ((DO_State)this.get$obj$state(false)).saldo;
    }
    
    public void setSaldo(java.lang.Integer saldo) {
        ((DO_State)this.get$obj$state(true)).saldo = saldo;
    }
    
    private java.lang.Integer get$saldo() {
        java.lang.Integer value = ((DO_State)this.get$obj$state(false)).saldo;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForInteger(value);
    }
    
    private final void set$saldo(java.lang.Integer arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).saldo = (java.lang.Integer)((arg0 == null) ? null : arg0);
    }
    
    public int getPratoCount() {
        return get$rl$prato().size();
    }
    
    public boolean hasAnyPrato() {
        return (! get$rl$prato().isEmpty());
    }
    
    public boolean hasPrato(pt.ist.rest.domain.Prato prato) {
        return get$rl$prato().contains(prato);
    }
    
    public java.util.Set<pt.ist.rest.domain.Prato> getPratoSet() {
        return get$rl$prato();
    }
    
    public void addPrato(pt.ist.rest.domain.Prato prato) {
        ClienteContainsPratos.add((pt.ist.rest.domain.Cliente)this, prato);
    }
    
    public void removePrato(pt.ist.rest.domain.Prato prato) {
        ClienteContainsPratos.remove((pt.ist.rest.domain.Cliente)this, prato);
    }
    
    public java.util.List<pt.ist.rest.domain.Prato> getPrato() {
        return get$rl$prato();
    }
    
    public void set$prato(OJBFunctionalSetWrapper prato) {
        get$rl$prato().setFromOJB(this, "prato", prato);
    }
    
    public java.util.Iterator<pt.ist.rest.domain.Prato> getPratoIterator() {
        return get$rl$prato().iterator();
    }
    
    public pt.ist.rest.domain.Rest getRest() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "rest");
        return ((DO_State)this.get$obj$state(false)).rest;
    }
    
    public void setRest(pt.ist.rest.domain.Rest rest) {
        RestContainsClientes.add((pt.ist.rest.domain.Cliente)this, rest);
    }
    
    public boolean hasRest() {
        return (getRest() != null);
    }
    
    public void removeRest() {
        setRest(null);
    }
    
    private java.lang.Long get$oidRest() {
        pt.ist.fenixframework.pstm.AbstractDomainObject value = ((DO_State)this.get$obj$state(false)).rest;
        return (value == null) ? null : value.getOid();
    }
    
    public int getCompraCount() {
        return get$rl$compra().size();
    }
    
    public boolean hasAnyCompra() {
        return (! get$rl$compra().isEmpty());
    }
    
    public boolean hasCompra(pt.ist.rest.domain.Compra compra) {
        return get$rl$compra().contains(compra);
    }
    
    public java.util.Set<pt.ist.rest.domain.Compra> getCompraSet() {
        return get$rl$compra();
    }
    
    public void addCompra(pt.ist.rest.domain.Compra compra) {
        ClienteContainsCompras.add((pt.ist.rest.domain.Cliente)this, compra);
    }
    
    public void removeCompra(pt.ist.rest.domain.Compra compra) {
        ClienteContainsCompras.remove((pt.ist.rest.domain.Cliente)this, compra);
    }
    
    public java.util.List<pt.ist.rest.domain.Compra> getCompra() {
        return get$rl$compra();
    }
    
    public void set$compra(OJBFunctionalSetWrapper compra) {
        get$rl$compra().setFromOJB(this, "compra", compra);
    }
    
    public java.util.Iterator<pt.ist.rest.domain.Compra> getCompraIterator() {
        return get$rl$compra().iterator();
    }
    
    protected void checkDisconnected() {
        super.checkDisconnected();
        if (hasAnyPrato()) handleAttemptToDeleteConnectedObject();
        if (hasRest()) handleAttemptToDeleteConnectedObject();
        if (hasAnyCompra()) handleAttemptToDeleteConnectedObject();
        
    }
    
    protected void readStateFromResultSet(java.sql.ResultSet rs, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  state) throws java.sql.SQLException {
        super.readStateFromResultSet(rs, state);
        DO_State castedState = (DO_State)state;
        set$nome(pt.ist.fenixframework.pstm.ResultSetReader.readString(rs, "NOME"), state);
        set$morada(pt.ist.fenixframework.pstm.ResultSetReader.readString(rs, "MORADA"), state);
        set$email(pt.ist.fenixframework.pstm.ResultSetReader.readString(rs, "EMAIL"), state);
        set$nif(pt.ist.fenixframework.pstm.ResultSetReader.readInteger(rs, "NIF"), state);
        set$saldo(pt.ist.fenixframework.pstm.ResultSetReader.readInteger(rs, "SALDO"), state);
        castedState.rest = pt.ist.fenixframework.pstm.ResultSetReader.readDomainObject(rs, "OID_REST");
    }
    protected dml.runtime.Relation get$$relationFor(String attrName) {
        if (attrName.equals("prato")) return ClienteContainsPratos;
        if (attrName.equals("compra")) return ClienteContainsCompras;
        return super.get$$relationFor(attrName);
        
    }
    protected pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  make$newState() {
        return new DO_State();
        
    }
    protected void create$allLists() {
        super.create$allLists();
        get$$relationList("prato", ClienteContainsPratos);
        get$$relationList("compra", ClienteContainsCompras);
        
    }
    protected static class DO_State extends pt.ist.rest.domain.Utilizador.DO_State {
        private java.lang.String nome;
        private java.lang.String morada;
        private java.lang.String email;
        private java.lang.Integer nif;
        private java.lang.Integer saldo;
        private pt.ist.rest.domain.Rest rest;
        protected void copyTo(pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  newState) {
            super.copyTo(newState);
            DO_State newCasted = (DO_State)newState;
            newCasted.nome = this.nome;
            newCasted.morada = this.morada;
            newCasted.email = this.email;
            newCasted.nif = this.nif;
            newCasted.saldo = this.saldo;
            newCasted.rest = this.rest;
            
        }
        
        // serialization code
        protected Object writeReplace() throws java.io.ObjectStreamException {
            return new SerializedForm(this);
        }
        
        protected static class SerializedForm extends pt.ist.rest.domain.Utilizador.DO_State.SerializedForm {
            private static final long serialVersionUID = 1L;
            
            private java.lang.String nome;
            private java.lang.String morada;
            private java.lang.String email;
            private java.lang.Integer nif;
            private java.lang.Integer saldo;
            private pt.ist.rest.domain.Rest rest;
            
            protected  SerializedForm(DO_State obj) {
                super(obj);
                this.nome = obj.nome;
                this.morada = obj.morada;
                this.email = obj.email;
                this.nif = obj.nif;
                this.saldo = obj.saldo;
                this.rest = obj.rest;
                
            }
            
             Object readResolve() throws java.io.ObjectStreamException {
                DO_State newState = new DO_State();
                fillInState(newState);
                return newState;
            }
            
            protected void fillInState(pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State obj) {
                super.fillInState(obj);
                DO_State state = (DO_State)obj;
                state.nome = this.nome;
                state.morada = this.morada;
                state.email = this.email;
                state.nif = this.nif;
                state.saldo = this.saldo;
                state.rest = this.rest;
                
            }
            
        }
        
    }
    
}
