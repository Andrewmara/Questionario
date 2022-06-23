export class QuestionarioUtente{
    public punteggio!: number;
    public id_questionario!: number;
    public id_utente!: number;
    public titolo!:string;
    public descrizione!:string;
    constructor(punteggio:number, id_questionario: number, id_utente: number){
        this.punteggio = punteggio
        this.id_questionario = id_questionario
        this.id_utente = id_utente
    }
}
