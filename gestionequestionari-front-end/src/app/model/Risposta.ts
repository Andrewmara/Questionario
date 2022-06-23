export class Risposta{
    public id!: number;
    public id_utente!: number;
    public risposta!: string;
    public id_questionario!:number
    constructor(id: number,id_questionario:number,id_utente:number, risposta: string){
        this.id = id
        this.id_questionario = id_questionario
        this.risposta = risposta
        this.id_utente = id_utente
    }
}
