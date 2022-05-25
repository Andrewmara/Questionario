export class QuestionarioUtente{
    public punteggio!: number;
    public questionario!: number;
    public utente!: number;
    public titolo!:string;
    public descrizione!:string;
    constructor(punteggio:number, questionario: number, utente: number){
        this.punteggio = punteggio
        this.questionario = questionario
        this.utente = utente
    }
}