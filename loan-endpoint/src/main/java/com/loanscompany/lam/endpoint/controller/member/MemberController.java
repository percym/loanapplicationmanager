package com.loanscompany.lam.endpoint.controller.member;


import com.codahale.metrics.annotation.Timed;
import com.loanscompany.lam.endpoint.appconfig.security.jwt.message.response.ResponseMessage;
import com.loanscompany.lam.iservice.member.IMemberService;
import com.loanscompany.lam.model.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Rest controller for managing members
 *
 * @author Percy Mugadza
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class MemberController {

    final IMemberService memberService;

    public MemberController(IMemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * GET  /member: get all the members.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of members in body
     */
    @GetMapping("/member")
    @Timed
    public ResponseEntity<List<Member>> getAllMember() {
        log.debug("REST request to get all IMember");
        List<Member> members = memberService.findAll();
        return new ResponseEntity<>(members, null, HttpStatus.OK);
    }

    /**
     * POST  /member: save member.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of members in body
     */
    @PostMapping("/member")
    @Timed
    public ResponseEntity<?> saveMember(@Valid @RequestBody Member member) {
        log.debug("REST request to get all IMember");
        if (member.getId() != null) {
            return   new ResponseEntity<>(new ResponseMessage("Fail ->Enter valid member id!"),
                    HttpStatus.BAD_REQUEST);
        }
            Member savedMember = memberService.save(member);
        return new ResponseEntity<>(savedMember, null, HttpStatus.OK);
    }

    /**
     * PUT  /member: update member.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of members in body
     */
    @PutMapping("/member")
    @Timed
    public ResponseEntity<?> updateMember(@Valid @RequestBody Member member) {
        log.debug("REST request to get all IMember");
        if (member.getId() == null) {
            return   new ResponseEntity<>(new ResponseMessage("Fail ->Enter valid member id!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (member.getId() == 0) {
            return   new ResponseEntity<>(new ResponseMessage("Fail ->Enter valid member id!"),
                    HttpStatus.BAD_REQUEST);
        }

        Member savedMember = memberService.save(member);
        return new ResponseEntity<>(savedMember, null, HttpStatus.OK);
    }

    /**
     * GET  /member/client/{clientId}: get all the members by clientId.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of members in body
     */
    @GetMapping("/member/client/{clientId}")
    @Timed
    public ResponseEntity<List<Member>> getAllByClientId(@PathVariable Long clientId) {
        log.debug("REST request to get all IMember");
        List<Member> members = memberService.findAllBySystemUser_Location_Client_Id(clientId);
        return new ResponseEntity<>(members, null, HttpStatus.OK);
    }

    /**
     * GET  /member/user/{userId}: get all the members by userId.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of members in body
     */
    @GetMapping("/member/user/{userId}")
    @Timed
    public ResponseEntity<List<Member>> getAllByUserId(@PathVariable Long clientId) {
        log.debug("REST request to get all IMember");
        List<Member> members = memberService.findAllBySystemUser_Location_Client_Id(clientId);
        return new ResponseEntity<>(members, null, HttpStatus.OK);
    }

    /**
     * GET  /member/{memberId}: get all the members by Id.
     *
     * @return the ResponseEntity with status 200 (OK) and the  member in body
     */
    @GetMapping("/member/{memberId}")
    @Timed
    public ResponseEntity<Member> getOneById(@PathVariable Long memberId) {
        log.debug("REST request to get all IMember");
        Member member = memberService.findOne(memberId);
        return new ResponseEntity<>(member, null, HttpStatus.OK);
    }
}
