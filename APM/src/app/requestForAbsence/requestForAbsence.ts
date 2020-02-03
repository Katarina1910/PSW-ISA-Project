export class RequestForAbsence {
    constructor(
        public  id: number,
        public  applicant: number,
        private  isAccepted: boolean,
        private resaonOfRejection: string,
        private from: Date,
        private to: Date,
        private clinicAdministrator: number
    ){}
}