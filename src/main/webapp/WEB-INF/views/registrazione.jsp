<%@include file="/WEB-INF/views/template/header.jsp"%>

<section id="services">
    <div class="container-fluid">
        <div class="col-lg-8 col-lg-offset-2 text-center">
            <h1 class="section-heading">Registrati</h1>
        </div>

    </div>
    <div class="container-fluid">
    <c:if test="${!(Error==null)}"><div class="alert alert-danger">${Error}</div></c:if>
    </div>
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form" action="Register" method=post>
                <hr class="colorgraph">
                <div class="row">

                    <div class="col-xs-12 col-sm-6 col-md-6">
                            <div class="form-group">
                            <input type="text" name="first_name" id="first_name" class="form-control input-lg" placeholder="First Name" tabindex="1" required>
                            </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="text" name="last_name" id="last_name" class="form-control input-lg" placeholder="Last Name" tabindex="2" required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <input type="text" name="DataN" id="DataN" class="form-control input-lg" placeholder="Data di nascita" tabindex="3" required>
                </div>
                <div class="form-group">
                    <input type="indirizzo" name="indirizzo" id="indirizzo" class="form-control input-lg" placeholder="Indirizzo" tabindex="4" required>
                </div>
                <div class="form-group">
                    <input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email Address" tabindex="5" required>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password" tabindex="6"required>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-lg" placeholder="Confirm Password" tabindex="6" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-8 col-sm-9 col-md-9">
                        By clicking <strong class="label label-primary">Register</strong>, you agree to the <a href="#" data-toggle="modal" data-target="#t_and_c_m">Terms and Conditions</a> set out by this site, including our Cookie Use.
                    </div>
                </div>

                <hr class="colorgraph">
                <div class="row">
                    <div class="col-xs-12 col-md-6"><input type="submit" value="Register" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
                </div>
            </form>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
                </div>
                <div class="modal-body">
                    <p>Le presenti Condizioni Generali di Contratto (CGC) disciplinano la compravendita a distanza e, per quanto compatibili e non altrimenti derogate, la compravendita non a distanza, dei biglietti per eventi nazionali e internazionali di spettacolo e/o di intrattenimento culturale e sportivo, effettuata da eventManager S.p.A. in nome e per conto dell'organizzatore dell'evento nonche' il contratto di fornitura dei servizi, necessari e accessori alla compravendita di tali biglietti, prestati da eventManager S.p.A.</p>
                    <p>L'acquisto dei Titoli di Ingresso sul Sito puo' avvenire solo previa registrazione al Sito con le modalità di cui all'art. 5 che segue ed e' consentito sia a utenti che rivestano la qualita' di Consumatori sia a utenti che non rivestano tale qualita'. Alle persone fisiche l'acquisto e' consentito solo a condizione che esse abbiano compiuto gli anni 18.</p>
                    <p>EventManager si riserva il diritto di rifiutare o cancellare ordini che provengano (i) da un utente con cui essa abbia in corso un contenzioso legale; (ii) da un utente che abbia in precedenza violato le presenti CGC e/o le condizioni e/o i termini del Contratto; (iii) da un utente che sia stato coinvolto in frodi di qualsiasi tipo e, in particolare, in frodi relative a pagamenti con carta di credito; (iv) da utenti che abbiano rilasciato dati identificativi falsi, inventati, di fantasia, incompleti o comunque inesatti e/o in qualsiasi modo non corrispondenti al vero o riferiti a terze persone ovvero che non abbiano inviato tempestivamente a eventManager i documenti dalla stessa richiesti nell'ambito della procedura di cui agli artt. 11.1.2 e 11.1.3 che seguono o che le abbiano inviato documenti non validi.</p>
                    <p>La registrazione al Sito e' gratuita. Per registrarsi al Sito e creare il relativo account l'utente deve compilare l'apposito modulo, inserendo i propri dati personali nello stesso richiesti, oltre a un indirizzo e-mail e a una password, e cliccare sul tasto ''Register'. E' assolutamente e severamente vietato all'utente l'inserimento, ai fini della registrazione al Sito, di dati personali di terze persone, di dati falsi, inventati, di fantasia e/o, in qualsiasi modo, non corrispondenti al vero.</p>
                    <p>Ciascun utente puo' usufruire di una sola registrazione al Sito. E' pertanto assolutamente e severamente vietato all'utente creare sul Sito piu' account riferibili alla stessa persona, fisica e/o giuridica, e/o a societa' e/o enti di qualsiasi tipo, anche mediante l'utilizzo di dati corrispondenti al vero. Nel caso di violazione di tale divieto, fermo quanto previsto all'art. 4.2 che precede, eventManager si riserva la facolta' di chiudere tutti gli account riferibili alla stessa persona, fisica e/o giuridica, e/o alla stessa societa' e/o allo stesso ente. L'utente si impegna inoltre a tenere eventManager indenne e manlevata da qualsiasi danno, obbligo risarcitorio e/o sanzione derivante da e/o in qualsiasi modo collegata alla violazione da parte dell'utente del divieto di cui al presente articolo 5.2.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">I Agree</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>
</section>

