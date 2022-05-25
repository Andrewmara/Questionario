export class Risposta{
    public id_utente!: number;
    public domanda!: number;
    public risposta!: string;
    constructor(id_utente:number, domanda: number, risposta: string){
        this.id_utente = id_utente
        this.domanda = domanda
        this.risposta = risposta
    }
}