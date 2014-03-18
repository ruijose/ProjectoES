package pt.ist.rest.domain;

import pt.ist.fenixframework.pstm.VBox;
import pt.ist.fenixframework.pstm.RelationList;
import pt.ist.fenixframework.pstm.OJBFunctionalSetWrapper;
import pt.ist.fenixframework.ValueTypeSerializationGenerator.*;
public abstract class Rest_Base extends pt.ist.fenixframework.pstm.OneBoxDomainObject {
    public final static dml.runtime.RoleMany<pt.ist.rest.domain.Rest,pt.ist.rest.domain.Cliente> role$$cliente = new dml.runtime.RoleMany<pt.ist.rest.domain.Rest,pt.ist.rest.domain.Cliente>() {
        public dml.runtime.RelationBaseSet<pt.ist.rest.domain.Cliente> getSet(pt.ist.rest.domain.Rest o1) {
            return ((Rest_Base)o1).get$rl$cliente();
        }
        public dml.runtime.Role<pt.ist.rest.domain.Cliente,pt.ist.rest.domain.Rest> getInverseRole() {
            return pt.ist.rest.domain.Cliente.role$$rest;
        }
        
    };
    public final static dml.runtime.RoleMany<pt.ist.rest.domain.Rest,pt.ist.rest.domain.Restaurante> role$$restaurante = new dml.runtime.RoleMany<pt.ist.rest.domain.Rest,pt.ist.rest.domain.Restaurante>() {
        public dml.runtime.RelationBaseSet<pt.ist.rest.domain.Restaurante> getSet(pt.ist.rest.domain.Rest o1) {
            return ((Rest_Base)o1).get$rl$restaurante();
        }
        public dml.runtime.Role<pt.ist.rest.domain.Restaurante,pt.ist.rest.domain.Rest> getInverseRole() {
            return pt.ist.rest.domain.Restaurante.role$$rest;
        }
        
    };
    public final static dml.runtime.RoleMany<pt.ist.rest.domain.Rest,pt.ist.rest.domain.Utilizador> role$$utilizador = new dml.runtime.RoleMany<pt.ist.rest.domain.Rest,pt.ist.rest.domain.Utilizador>() {
        public dml.runtime.RelationBaseSet<pt.ist.rest.domain.Utilizador> getSet(pt.ist.rest.domain.Rest o1) {
            return ((Rest_Base)o1).get$rl$utilizador();
        }
        public dml.runtime.Role<pt.ist.rest.domain.Utilizador,pt.ist.rest.domain.Rest> getInverseRole() {
            return pt.ist.rest.domain.Utilizador.role$$rest;
        }
        
    };
    public static dml.runtime.Relation<pt.ist.rest.domain.Rest,pt.ist.rest.domain.Cliente> RestContainsClientes;
    public static dml.runtime.Relation<pt.ist.rest.domain.Rest,pt.ist.rest.domain.Restaurante> RestContainsRestaurantes;
    public static dml.runtime.Relation<pt.ist.rest.domain.Rest,pt.ist.rest.domain.Utilizador> RestContainsUtilizadores;
    
    
    private RelationList<pt.ist.rest.domain.Rest,pt.ist.rest.domain.Cliente> get$rl$cliente() {
        return get$$relationList("cliente", RestContainsClientes);
        
    }
    private RelationList<pt.ist.rest.domain.Rest,pt.ist.rest.domain.Restaurante> get$rl$restaurante() {
        return get$$relationList("restaurante", RestContainsRestaurantes);
        
    }
    private RelationList<pt.ist.rest.domain.Rest,pt.ist.rest.domain.Utilizador> get$rl$utilizador() {
        return get$$relationList("utilizador", RestContainsUtilizadores);
        
    }
    
    
    private void initInstance() {
        initInstance(true);
    }
    
    private void initInstance(boolean allocateOnly) {
        
    }
    
    {
        initInstance(false);
    }
    
    protected  Rest_Base() {
        super();
    }
    
    public java.lang.Integer getIDPrato() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "IDPrato");
        return ((DO_State)this.get$obj$state(false)).IDPrato;
    }
    
    public void setIDPrato(java.lang.Integer IDPrato) {
        ((DO_State)this.get$obj$state(true)).IDPrato = IDPrato;
    }
    
    private java.lang.Integer get$IDPrato() {
        java.lang.Integer value = ((DO_State)this.get$obj$state(false)).IDPrato;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForInteger(value);
    }
    
    private final void set$IDPrato(java.lang.Integer arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).IDPrato = (java.lang.Integer)((arg0 == null) ? null : arg0);
    }
    
    public int getClienteCount() {
        return get$rl$cliente().size();
    }
    
    public boolean hasAnyCliente() {
        return (! get$rl$cliente().isEmpty());
    }
    
    public boolean hasCliente(pt.ist.rest.domain.Cliente cliente) {
        return get$rl$cliente().contains(cliente);
    }
    
    public java.util.Set<pt.ist.rest.domain.Cliente> getClienteSet() {
        return get$rl$cliente();
    }
    
    public void addCliente(pt.ist.rest.domain.Cliente cliente) {
        RestContainsClientes.add((pt.ist.rest.domain.Rest)this, cliente);
    }
    
    public void removeCliente(pt.ist.rest.domain.Cliente cliente) {
        RestContainsClientes.remove((pt.ist.rest.domain.Rest)this, cliente);
    }
    
    public java.util.List<pt.ist.rest.domain.Cliente> getCliente() {
        return get$rl$cliente();
    }
    
    public void set$cliente(OJBFunctionalSetWrapper cliente) {
        get$rl$cliente().setFromOJB(this, "cliente", cliente);
    }
    
    public java.util.Iterator<pt.ist.rest.domain.Cliente> getClienteIterator() {
        return get$rl$cliente().iterator();
    }
    
    public int getRestauranteCount() {
        return get$rl$restaurante().size();
    }
    
    public boolean hasAnyRestaurante() {
        return (! get$rl$restaurante().isEmpty());
    }
    
    public boolean hasRestaurante(pt.ist.rest.domain.Restaurante restaurante) {
        return get$rl$restaurante().contains(restaurante);
    }
    
    public java.util.Set<pt.ist.rest.domain.Restaurante> getRestauranteSet() {
        return get$rl$restaurante();
    }
    
    public void addRestaurante(pt.ist.rest.domain.Restaurante restaurante) {
        RestContainsRestaurantes.add((pt.ist.rest.domain.Rest)this, restaurante);
    }
    
    public void removeRestaurante(pt.ist.rest.domain.Restaurante restaurante) {
        RestContainsRestaurantes.remove((pt.ist.rest.domain.Rest)this, restaurante);
    }
    
    public java.util.List<pt.ist.rest.domain.Restaurante> getRestaurante() {
        return get$rl$restaurante();
    }
    
    public void set$restaurante(OJBFunctionalSetWrapper restaurante) {
        get$rl$restaurante().setFromOJB(this, "restaurante", restaurante);
    }
    
    public java.util.Iterator<pt.ist.rest.domain.Restaurante> getRestauranteIterator() {
        return get$rl$restaurante().iterator();
    }
    
    public int getUtilizadorCount() {
        return get$rl$utilizador().size();
    }
    
    public boolean hasAnyUtilizador() {
        return (! get$rl$utilizador().isEmpty());
    }
    
    public boolean hasUtilizador(pt.ist.rest.domain.Utilizador utilizador) {
        return get$rl$utilizador().contains(utilizador);
    }
    
    public java.util.Set<pt.ist.rest.domain.Utilizador> getUtilizadorSet() {
        return get$rl$utilizador();
    }
    
    public void addUtilizador(pt.ist.rest.domain.Utilizador utilizador) {
        RestContainsUtilizadores.add((pt.ist.rest.domain.Rest)this, utilizador);
    }
    
    public void removeUtilizador(pt.ist.rest.domain.Utilizador utilizador) {
        RestContainsUtilizadores.remove((pt.ist.rest.domain.Rest)this, utilizador);
    }
    
    public java.util.List<pt.ist.rest.domain.Utilizador> getUtilizador() {
        return get$rl$utilizador();
    }
    
    public void set$utilizador(OJBFunctionalSetWrapper utilizador) {
        get$rl$utilizador().setFromOJB(this, "utilizador", utilizador);
    }
    
    public java.util.Iterator<pt.ist.rest.domain.Utilizador> getUtilizadorIterator() {
        return get$rl$utilizador().iterator();
    }
    
    protected void checkDisconnected() {
        if (hasAnyCliente()) handleAttemptToDeleteConnectedObject();
        if (hasAnyRestaurante()) handleAttemptToDeleteConnectedObject();
        if (hasAnyUtilizador()) handleAttemptToDeleteConnectedObject();
        
    }
    
    protected void readStateFromResultSet(java.sql.ResultSet rs, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  state) throws java.sql.SQLException {
        DO_State castedState = (DO_State)state;
        set$IDPrato(pt.ist.fenixframework.pstm.ResultSetReader.readInteger(rs, "I_D_PRATO"), state);
    }
    protected dml.runtime.Relation get$$relationFor(String attrName) {
        if (attrName.equals("cliente")) return RestContainsClientes;
        if (attrName.equals("restaurante")) return RestContainsRestaurantes;
        if (attrName.equals("utilizador")) return RestContainsUtilizadores;
        return super.get$$relationFor(attrName);
        
    }
    protected pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  make$newState() {
        return new DO_State();
        
    }
    protected void create$allLists() {
        super.create$allLists();
        get$$relationList("cliente", RestContainsClientes);
        get$$relationList("restaurante", RestContainsRestaurantes);
        get$$relationList("utilizador", RestContainsUtilizadores);
        
    }
    protected static class DO_State extends pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State {
        private java.lang.Integer IDPrato;
        protected void copyTo(pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  newState) {
            super.copyTo(newState);
            DO_State newCasted = (DO_State)newState;
            newCasted.IDPrato = this.IDPrato;
            
        }
        
        // serialization code
        protected Object writeReplace() throws java.io.ObjectStreamException {
            return new SerializedForm(this);
        }
        
        protected static class SerializedForm extends pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State.SerializedForm {
            private static final long serialVersionUID = 1L;
            
            private java.lang.Integer IDPrato;
            
            protected  SerializedForm(DO_State obj) {
                super(obj);
                this.IDPrato = obj.IDPrato;
                
            }
            
             Object readResolve() throws java.io.ObjectStreamException {
                DO_State newState = new DO_State();
                fillInState(newState);
                return newState;
            }
            
            protected void fillInState(pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State obj) {
                super.fillInState(obj);
                DO_State state = (DO_State)obj;
                state.IDPrato = this.IDPrato;
                
            }
            
        }
        
    }
    
}
