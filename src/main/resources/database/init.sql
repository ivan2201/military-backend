--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.24
-- Dumped by pg_dump version 10.5

-- Started on 2022-07-11 09:48:43

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 188 (class 1259 OID 24656)
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    id integer NOT NULL,
    category_number integer,
    category_name text
);


ALTER TABLE public.category OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 24654)
-- Name: category_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.category_id_seq OWNER TO postgres;

--
-- TOC entry 2207 (class 0 OID 0)
-- Dependencies: 187
-- Name: category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.category_id_seq OWNED BY public.category.id;


--
-- TOC entry 190 (class 1259 OID 24667)
-- Name: certificate; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.certificate (
    id integer NOT NULL,
    cert_number text,
    approve_date date,
    recert_date date,
    id_category integer,
    cert_creator text
);


ALTER TABLE public.certificate OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 24665)
-- Name: certificate_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.certificate_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.certificate_id_seq OWNER TO postgres;

--
-- TOC entry 2208 (class 0 OID 0)
-- Dependencies: 189
-- Name: certificate_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.certificate_id_seq OWNED BY public.certificate.id;


--
-- TOC entry 200 (class 1259 OID 24747)
-- Name: components; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.components (
    id integer NOT NULL,
    name text,
    series_number text,
    oi_id integer
);


ALTER TABLE public.components OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 24745)
-- Name: components_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.components_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.components_id_seq OWNER TO postgres;

--
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 199
-- Name: components_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.components_id_seq OWNED BY public.components.id;


--
-- TOC entry 196 (class 1259 OID 24705)
-- Name: inner_document; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inner_document (
    id integer NOT NULL,
    name text,
    registration_number text,
    approve_date date,
    oi_id integer
);


ALTER TABLE public.inner_document OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 24703)
-- Name: inner_document_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.inner_document_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.inner_document_id_seq OWNER TO postgres;

--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 195
-- Name: inner_document_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.inner_document_id_seq OWNED BY public.inner_document.id;


--
-- TOC entry 186 (class 1259 OID 24645)
-- Name: military_base; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.military_base (
    id integer NOT NULL,
    name text,
    base_number integer,
    location text
);


ALTER TABLE public.military_base OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 24643)
-- Name: military_base_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.military_base_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.military_base_id_seq OWNER TO postgres;

--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 185
-- Name: military_base_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.military_base_id_seq OWNED BY public.military_base.id;


--
-- TOC entry 198 (class 1259 OID 24716)
-- Name: object_informatization; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.object_informatization (
    id integer NOT NULL,
    name text,
    cert_id integer,
    si_id integer,
    scr_id integer,
    military_base_id integer
);


ALTER TABLE public.object_informatization OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 24714)
-- Name: object_informatization_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.object_informatization_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.object_informatization_id_seq OWNER TO postgres;

--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 197
-- Name: object_informatization_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.object_informatization_id_seq OWNED BY public.object_informatization.id;


--
-- TOC entry 194 (class 1259 OID 24694)
-- Name: special_check_result; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.special_check_result (
    id integer NOT NULL,
    scr_number text,
    approve_date date
);


ALTER TABLE public.special_check_result OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 24692)
-- Name: special_check_result_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.special_check_result_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.special_check_result_id_seq OWNER TO postgres;

--
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 193
-- Name: special_check_result_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.special_check_result_id_seq OWNED BY public.special_check_result.id;


--
-- TOC entry 192 (class 1259 OID 24683)
-- Name: special_investigation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.special_investigation (
    id integer NOT NULL,
    si_number text,
    approve_date date
);


ALTER TABLE public.special_investigation OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 24681)
-- Name: special_investigation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.special_investigation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.special_investigation_id_seq OWNER TO postgres;

--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 191
-- Name: special_investigation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.special_investigation_id_seq OWNED BY public.special_investigation.id;


--
-- TOC entry 2052 (class 2604 OID 24659)
-- Name: category id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category ALTER COLUMN id SET DEFAULT nextval('public.category_id_seq'::regclass);


--
-- TOC entry 2053 (class 2604 OID 24670)
-- Name: certificate id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.certificate ALTER COLUMN id SET DEFAULT nextval('public.certificate_id_seq'::regclass);


--
-- TOC entry 2058 (class 2604 OID 24750)
-- Name: components id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.components ALTER COLUMN id SET DEFAULT nextval('public.components_id_seq'::regclass);


--
-- TOC entry 2056 (class 2604 OID 24708)
-- Name: inner_document id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inner_document ALTER COLUMN id SET DEFAULT nextval('public.inner_document_id_seq'::regclass);


--
-- TOC entry 2051 (class 2604 OID 24648)
-- Name: military_base id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.military_base ALTER COLUMN id SET DEFAULT nextval('public.military_base_id_seq'::regclass);


--
-- TOC entry 2057 (class 2604 OID 24719)
-- Name: object_informatization id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.object_informatization ALTER COLUMN id SET DEFAULT nextval('public.object_informatization_id_seq'::regclass);


--
-- TOC entry 2055 (class 2604 OID 24697)
-- Name: special_check_result id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.special_check_result ALTER COLUMN id SET DEFAULT nextval('public.special_check_result_id_seq'::regclass);


--
-- TOC entry 2054 (class 2604 OID 24686)
-- Name: special_investigation id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.special_investigation ALTER COLUMN id SET DEFAULT nextval('public.special_investigation_id_seq'::regclass);


--
-- TOC entry 2062 (class 2606 OID 24664)
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- TOC entry 2064 (class 2606 OID 24675)
-- Name: certificate certificate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.certificate
    ADD CONSTRAINT certificate_pkey PRIMARY KEY (id);


--
-- TOC entry 2074 (class 2606 OID 24755)
-- Name: components components_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.components
    ADD CONSTRAINT components_pkey PRIMARY KEY (id);


--
-- TOC entry 2070 (class 2606 OID 24713)
-- Name: inner_document inner_document_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inner_document
    ADD CONSTRAINT inner_document_pkey PRIMARY KEY (id);


--
-- TOC entry 2060 (class 2606 OID 24653)
-- Name: military_base military_base_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.military_base
    ADD CONSTRAINT military_base_pkey PRIMARY KEY (id);


--
-- TOC entry 2072 (class 2606 OID 24724)
-- Name: object_informatization object_informatization_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.object_informatization
    ADD CONSTRAINT object_informatization_pkey PRIMARY KEY (id);


--
-- TOC entry 2068 (class 2606 OID 24702)
-- Name: special_check_result special_check_result_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.special_check_result
    ADD CONSTRAINT special_check_result_pkey PRIMARY KEY (id);


--
-- TOC entry 2066 (class 2606 OID 24691)
-- Name: special_investigation special_investigation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.special_investigation
    ADD CONSTRAINT special_investigation_pkey PRIMARY KEY (id);


--
-- TOC entry 2075 (class 2606 OID 24676)
-- Name: certificate certificate_id_category_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.certificate
    ADD CONSTRAINT certificate_id_category_fkey FOREIGN KEY (id_category) REFERENCES public.category(id);


--
-- TOC entry 2081 (class 2606 OID 24756)
-- Name: components components_oi_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.components
    ADD CONSTRAINT components_oi_id_fkey FOREIGN KEY (oi_id) REFERENCES public.object_informatization(id);


--
-- TOC entry 2076 (class 2606 OID 24762)
-- Name: inner_document inner_document_oi_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inner_document
    ADD CONSTRAINT inner_document_oi_id_fkey FOREIGN KEY (oi_id) REFERENCES public.object_informatization(id);


--
-- TOC entry 2077 (class 2606 OID 24725)
-- Name: object_informatization object_informatization_cert_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.object_informatization
    ADD CONSTRAINT object_informatization_cert_id_fkey FOREIGN KEY (cert_id) REFERENCES public.certificate(id);


--
-- TOC entry 2080 (class 2606 OID 24740)
-- Name: object_informatization object_informatization_military_base_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.object_informatization
    ADD CONSTRAINT object_informatization_military_base_id_fkey FOREIGN KEY (military_base_id) REFERENCES public.military_base(id);


--
-- TOC entry 2079 (class 2606 OID 24735)
-- Name: object_informatization object_informatization_scr_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.object_informatization
    ADD CONSTRAINT object_informatization_scr_id_fkey FOREIGN KEY (scr_id) REFERENCES public.special_check_result(id);


--
-- TOC entry 2078 (class 2606 OID 24730)
-- Name: object_informatization object_informatization_si_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.object_informatization
    ADD CONSTRAINT object_informatization_si_id_fkey FOREIGN KEY (si_id) REFERENCES public.special_investigation(id);


-- Completed on 2022-07-11 09:48:44

--
-- PostgreSQL database dump complete
--

